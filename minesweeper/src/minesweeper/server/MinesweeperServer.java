/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper.server;

import java.io.*;
import java.net.*;
import java.util.*;

import minesweeper.Board;

/**
 * Multiplayer Minesweeper server.
 */
public class MinesweeperServer {

    // System thread safety argument: 
        //  all methods threadsafe since serve() and constructor confined to main thread,
        //  all incoming requests require lock on common this.game object to mutate it
        //  requires lock on this to add players or remove
    // System Liveness:
        //  all sub-methods of data-types only require lock on this and terminate, therefore no deadlock possible
    
    
    // single thread until serve() is called, at that point all bombs already
    // generated and board is set
    // while serving, clients may connect to the socket via set port, then
    // handleConnection() uses serverSocket for each user
    // in order to proceed after reading a line, user must acquire a lock on
    // this. Ensures processing of input and subsequent writing to output
    // limited to one thread at a time.

    /** Default server port. */
    private static final int DEFAULT_PORT = 4444;
    /** Maximum port number as defined by ServerSocket. */
    private static final int MAXIMUM_PORT = 65535;
    /** Default square board size. */
    private static final int DEFAULT_SIZE = 10;

    /** Socket for receiving incoming connections. */
    private final ServerSocket serverSocket;
    /**
     * True if the server should *not* disconnect a client after a BOOM message.
     */
    private final boolean debug;

    private final Board game;

    private int players;

    // Abstraction function:
    // represents a minesweeper server that can handle multiple clients
    // accepts requests of the form:
    // look, dig x y, flag x y, deflag x y, help, bye
    // returns output of the form:
    // hello_mesg, board, boom, help_msg
    // (see grammar for full form)
    //
    // Rep exposure:
    // - all fields private, final
    // - methods are void or return immutable objects

    /**
     * Make a MinesweeperServer that listens for connections on port.
     * 
     * @param port
     *            port number, requires 0 <= port <= 65535
     * @param debug
     *            debug mode flag
     * @param game 
     *              the board to set as this.game
     * @throws IOException
     *             if an error occurs opening the server socket
     */
    public MinesweeperServer(int port, boolean debug, Board game) throws IOException {
        // thread safety: confinement.
        // constructs before multiple threads possible

        serverSocket = new ServerSocket(port);
        this.debug = debug;
        this.game = game;
        players = 0;
    }

    /**
     * Run the server, listening for client connections and handling them. Never
     * returns unless an exception is thrown.
     * 
     * @throws IOException
     *             if the main server socket is broken (IOExceptions from
     *             individual clients do *not* terminate serve())
     */
    public void serve() throws IOException { // copied from
                                             // https://github.com/mit6005/sp16-ex22-square/blob/master/src/square/SquareServerMulti.java
        
        // thread safety: new thread constructor which runs on main thread, confined to main thread

        while (true) {
            // block until a client connects
            Socket socket = serverSocket.accept();
            synchronized(this){
                players += 1;
            }
            // handle the client on new thread
            Thread newThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        try {
                            handleConnection(socket);
                        } finally {
                            socket.close();
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace(); // but don't terminate serve()
                    }
                }
            });
            newThread.start();
        }
    }

    /**
     * Handle a single client connection. Returns when client disconnects.
     * 
     * @param socket
     *            socket where the client is connected
     * @throws IOException
     *             if the connection encounters an error or terminates
     *             unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException {

        // thread safety: incoming line request requires lock on game to be processed

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String welcome = "Welcome to Minesweeper. Board: " + game.getSizeX() + " columns by " + game.getSizeY()
                + " rows. Players: " + players + " including you. Type 'help' for help.";

        out.println(welcome);

        try {

            for (String line = in.readLine(); line != null; line = in.readLine()) {
                synchronized (game) {
                    String output = handleRequest(line);

                    if (!output.equals("closing connection")) {
                        out.println(output);
                        if (output.equals("BOOM!") && !debug) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            out.flush();

        } finally {
            synchronized(this){
                players -= 1;
            }
            out.close();
            in.close();
        }
    }

    /**
     * Handler for client input, performing requested operations and returning
     * an output message.
     * 
     * @param input
     *            message from client
     * @return message to client, or null if none
     */
    private String handleRequest(String input) {
        // thread safety: requires lock on game to mutate it! only one client
        // accessing this method at once
        synchronized (game) {

            String help = "you can use commands: look, help, flag x y, deflag x y, dig x y, bye, help.";
            String regex = "(look)|(help)|(bye)|" + "(dig -?\\d+ -?\\d+)|(flag -?\\d+ -?\\d+)|(deflag -?\\d+ -?\\d+)";
            if (!input.matches(regex)) {
                return help;
            }
            String[] tokens = input.split(" ");
            if (tokens[0].equals("look")) {
                // 'look' request
                return game.toString();
            } else if (tokens[0].equals("help")) {
                // 'help' request
                return help;
            } else if (tokens[0].equals("bye")) {
                // 'bye' request
                return "closing connection";
            } else {
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[2]);
                if (tokens[0].equals("dig")) {
                    boolean isBoom = game.dig(x, y);
                    if (isBoom) {
                        return "BOOM!";
                    } else {
                        return game.toString();
                    }
                } else if (tokens[0].equals("flag")) {
                    // 'flag x y' request
                    game.flag(x, y);
                    return game.toString();
                } else if (tokens[0].equals("deflag")) {
                    // 'deflag x y' request
                    game.unflag(x, y);
                    return game.toString();
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Start a MinesweeperServer using the given arguments.
     * 
     * <br>
     * Usage: MinesweeperServer [--debug | --no-debug] [--port PORT] [--size
     * SIZE_X,SIZE_Y | --file FILE]
     * 
     * <br>
     * The --debug argument means the server should run in debug mode. The
     * server should disconnect a client after a BOOM message if and only if the
     * --debug flag was NOT given. Using --no-debug is the same as using no flag
     * at all. <br>
     * E.g. "MinesweeperServer --debug" starts the server in debug mode.
     * 
     * <br>
     * PORT is an optional integer in the range 0 to 65535 inclusive, specifying
     * the port the server should be listening on for incoming connections. <br>
     * E.g. "MinesweeperServer --port 1234" starts the server listening on port
     * 1234.
     * 
     * <br>
     * SIZE_X and SIZE_Y are optional positive integer arguments, specifying
     * that a random board of size SIZE_X*SIZE_Y should be generated. <br>
     * E.g. "MinesweeperServer --size 42,58" starts the server initialized with
     * a random board of size 42*58.
     * 
     * <br>
     * FILE is an optional argument specifying a file pathname where a board has
     * been stored. If this argument is given, the stored board should be loaded
     * as the starting board. <br>
     * E.g. "MinesweeperServer --file boardfile.txt" starts the server
     * initialized with the board stored in boardfile.txt.
     * 
     * <br>
     * The board file format, for use with the "--file" option, is specified by
     * the following grammar:
     * 
     * <pre>
     *   FILE ::= BOARD LINE+
     *   BOARD ::= X SPACE Y NEWLINE
     *   LINE ::= (VAL SPACE)* VAL NEWLINE
     *   VAL ::= 0 | 1
     *   X ::= INT
     *   Y ::= INT
     *   SPACE ::= " "
     *   NEWLINE ::= "\n" | "\r" "\n"?
     *   INT ::= [0-9]+
     * </pre>
     * 
     * <br>
     * If neither --file nor --size is given, generate a random board of size
     * 10x10.
     * 
     * <br>
     * Note that --file and --size may not be specified simultaneously.
     * 
     * @param args
     *            arguments as described
     */
    public static void main(String[] args) {
        // Command-line argument parsing is provided. Do not change this method.
        boolean debug = false;
        int port = DEFAULT_PORT;
        int sizeX = DEFAULT_SIZE;
        int sizeY = DEFAULT_SIZE;
        Optional<File> file = Optional.empty();

        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        try {
            while (!arguments.isEmpty()) {
                String flag = arguments.remove();
                try {
                    if (flag.equals("--debug")) {
                        debug = true;
                    } else if (flag.equals("--no-debug")) {
                        debug = false;
                    } else if (flag.equals("--port")) {
                        port = Integer.parseInt(arguments.remove());
                        if (port < 0 || port > MAXIMUM_PORT) {
                            throw new IllegalArgumentException("port " + port + " out of range");
                        }
                    } else if (flag.equals("--size")) {
                        String[] sizes = arguments.remove().split(",");
                        sizeX = Integer.parseInt(sizes[0]);
                        sizeY = Integer.parseInt(sizes[1]);
                        file = Optional.empty();
                    } else if (flag.equals("--file")) {
                        sizeX = -1;
                        sizeY = -1;
                        file = Optional.of(new File(arguments.remove()));
                        if (!file.get().isFile()) {
                            throw new IllegalArgumentException("file not found: \"" + file.get() + "\"");
                        }
                    } else {
                        throw new IllegalArgumentException("unknown option: \"" + flag + "\"");
                    }
                } catch (NoSuchElementException nsee) {
                    throw new IllegalArgumentException("missing argument for " + flag);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("unable to parse number for " + flag);
                }
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            System.err.println(
                    "usage: MinesweeperServer [--debug | --no-debug] [--port PORT] [--size SIZE_X,SIZE_Y | --file FILE]");
            return;
        }

        try {
            runMinesweeperServer(debug, file, sizeX, sizeY, port);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Start a MinesweeperServer running on the specified port, with either a
     * random new board or a board loaded from a file.
     * 
     * @param debug
     *            The server will disconnect a client after a BOOM message if
     *            and only if debug is false.
     * @param file
     *            If file.isPresent(), start with a board loaded from the
     *            specified file, according to the input file format defined in
     *            the documentation for main(..).
     * @param sizeX
     *            If (!file.isPresent()), start with a random board with width
     *            sizeX (and require sizeX > 0).
     * @param sizeY
     *            If (!file.isPresent()), start with a random board with height
     *            sizeY (and require sizeY > 0).
     * @param port
     *            The network port on which the server should listen, requires 0
     *            <= port <= 65535.
     * @throws IOException
     *             if a network error occurs
     */
    public static void runMinesweeperServer(boolean debug, Optional<File> file, int sizeX, int sizeY, int port)
            throws IOException {
        // thread safety: called from main ==> confinement
        // until serve(), when multiple threads possible
        // at serve(): see serve

        double randomCutoff = 0.25;
        Board thisGame;

        if (file.isPresent()) {
            int indexX = 0;
            int indexY = 1;

            FileReader fileReader = new FileReader(file.get());
            BufferedReader reader = new BufferedReader(fileReader);

            String setup = reader.readLine();
            String[] lineSetup = setup.split(" ");
            int width = Integer.valueOf(lineSetup[indexX]);
            int height = Integer.valueOf(lineSetup[indexY]);

            thisGame = new Board(width, height);

            for (int row = 0; row < width; row++) {
                String s = reader.readLine();
                String[] line = s.split(" ");
                for (int col = 0; col < height; col++) {
                    if (Integer.valueOf(line[col]) == 1) {
                        thisGame.addBomb(col, row);
                    }
                }
            }
            reader.close();
        } else if (sizeX > 0 && sizeY > 0) {
            thisGame = new Board(sizeX, sizeY);
            for (int x = 0; x < sizeX; x++) {
                for (int y = 0; y < sizeY; y++) {
                    if (Math.random() < randomCutoff) {
                        thisGame.addBomb(x, y);
                    }
                }
            }
        } else {
            final int randSizeX = 10;
            final int randSizeY = 10;
            thisGame = new Board(randSizeX, randSizeY);
            for (int x = 0; x < randSizeX; x++) {
                for (int y = 0; y < randSizeY; y++) {
                    if (Math.random() < randomCutoff) {
                        thisGame.addBomb(x, y);
                    }
                }
            }
        }

        MinesweeperServer server = new MinesweeperServer(port, debug, thisGame);
        server.serve();
    }
}
