/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.List;


/**
 * Minesweeper board is a grid of unit cells which either contain a bomb or do not.
 * Cells initially are unknown to the player, who uncovers a bomb or not on each turn by digging a cell.
 * Players may flag a cell if they believe the cell contains a bomb, and that cell cannot be dug until unflagged.
 * Dug cells will reveal information about the surrounding cells, namely the count of bombs in adjacent cells.
 * If no bombs are in adjacent cells, then those cells are recursively dug by the game so new information is revealed.
 * If a player digs a bomb, then that player loses, the cell is vacated, and play continues for other players.
 */
public class Board {
    
    /* Abstraction function:
     *  Represents a sizeX by sizeY minesweeper board, with x and y coordinates listed starting in the top left corner with 0,0.
     *  
     * Rep invariant:
     *  each cell has neighboring bombs >= 0
     *  neighboring bombs count sums to number of bombs
     *  
     * Exposure:
     *  fields are private, final
     *  public methods only return immutable objects
     * 
     * Thread Safety:
     *  implements monitor pattern: locks on this for all methods
     *  constructor and addBomb methods only called from one thread before server starts
     *  private methods only used by current thread with lock
     *  Cell data-type is not thread safe, but cells only modified within methods with locks
     * 
     */
    private final int sizeX;
    private final int sizeY;
    
    private final List<List<Cell>> board;
    
    /*
     * check neighboring bombs 
     */
    private void checkRep(){
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                int numBombs = 0;
                Cell c = getCell(x,y);
                for (Tuple t: c.getNeighbors()){
                    if (getCell(t.getX(),t.getY()).isBomb()){
                        numBombs++;
                    }
                }
                
                assert c.getNeighborBombs()>=0;
                assert numBombs == c.getNeighborBombs();
                
            }
        }
    }
    
    /**
     * constructor method to create a new board
     * 
     * @param x horizontal number of cells
     * @param y vertical number of cells
     */
    public Board(int x, int y){
        //loops through x, y to create cells at those positions
        //threadsafe by confinement (only called from single thread before server starts)
        sizeX = x;
        sizeY = y;
        board = new ArrayList<List<Cell>>();
        for(int i = 0; i<sizeX; i++){
            board.add(new ArrayList<Cell>());
            for (int j=0; j< sizeY; j++){
                board.get(i).add(new Cell(sizeX, sizeY, i, j));
            }
        }
    }
    
    /**
     * Add a bomb to this board at position x, y if possible.
     * requires lock on this
     * 
     * @param x position
     * @param y position
     * @return true if bomb made, else false
     */
    public synchronized Boolean addBomb(int x, int y){
        //thread safe by monitor pattern and confinement: bombs only added in single thread before server starts and multiple users connect
        for (Tuple t : board.get(x).get(y).getNeighbors()){
            board.get(t.getX()).get(t.getY()).addNeighborBomb();
        }
        boolean output = board.get(x).get(y).makeBomb();
        checkRep();
        return output;
    }
    
    /**
     * Digs a square! Recursively reveals according to game rules.
     * requires lock on this 
     * 
     * @param x x-coord
     * @param y y-coord
     * @return true if bomb, false if no bomb
     */
    public synchronized boolean dig(int x, int y){
        //thread safe via monitor pattern:
        //  cells are mutable objects, so nobody can modify any of them in the board simultaneously else race conditions occur
        
        Cell current = board.get(x).get(y);
        if(current.getStatus().equals(Cell.STATUS_HIDDEN)){
            boolean foundBomb=false;
            
            if (current.isBomb()){
                current.unMakeBomb();
                for (Tuple t:current.getNeighbors()){
                    board.get(t.getX()).get(t.getY()).removeNeighborBomb();
                }
                foundBomb = true;
            } 
            reveal(current);
            checkRep();
            return foundBomb;
        }
        checkRep();
        return false;
    }
    
    /**
     * private method reveals squares recursively after a dig
     * 
     * @param current Cell that is currently to be revealed
     */
    private synchronized void reveal(Cell current){
        //thread safe since lock required on this can only be held by one thread at a time (parent call to dig)
        boolean more = current.reveal();
        if (more){
            for(Tuple t:current.getNeighbors()){
                reveal(board.get(t.getX()).get(t.getY()));
            }
        }
        checkRep();
    }
    
    /**
     * flags a square if possible based on rules of game.
     * 
     * @param x x-coord
     * @param y y-coord
     */
    public synchronized void flag(int x, int y){
        board.get(x).get(y).flag();
    }
    
    /**
     * 
     * @return horizontal size
     */
    public synchronized int getSizeX(){
        return sizeX;
    }
    
    /**
     * 
     * @return vertical size
     */
    public synchronized int getSizeY(){
        return sizeY;
    }
    
    /**
     * unflags a square if possible.
     * 
     * @param x coord
     * @param y coord
     */
    public synchronized void unflag(int x, int y){
        board.get(x).get(y).unflag();
    }
    
    /**
     * 
     * @return current board view as a string
     */
    private synchronized String viewBoard(){
        StringBuilder s = new StringBuilder();

        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                s.append(getCell(x,y).toString());
                if (x < sizeX-1){
                    s.append(" ");
                    
                }
            }
            if (y != sizeY - 1) s.append("\n");
        }
        return s.toString();
    }
    
    @Override
    public synchronized String toString(){
        return viewBoard();
    }
    
    @Override
    public synchronized boolean equals(Object that){
        if (!(that instanceof Board)) return false;
        Board thatBoard = (Board) that;
        boolean output = true;
        
        if(!(thatBoard.getSizeX()==sizeX) || !(thatBoard.getSizeY()==sizeY)) output = false;
        
        for (int x = 0; x < sizeX; x++){
            for (int y=0; y<sizeY; y++){
                if (! board.get(x).get(y).equals(thatBoard.getCell(x,y))) output = false;
            }
        }
        return output;
    }
    
    /**
     * private method for quickly performing board.get(x).get(y)
     * @param x location
     * @param y location
     * @return Cell at location x,y
     */
    private synchronized Cell getCell(int x, int y){
        return board.get(x).get(y);
    }
    
    @Override
    public synchronized int hashCode(){
        int output = toString().hashCode();
        return output;
    }
    
}

