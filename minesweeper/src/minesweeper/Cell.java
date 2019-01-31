package minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * threadsafe data-type 
 * 
 * @author Andrew
 *
 */
public class Cell {
    
    /*
     * Abstraction Func:
     *  represents a mutable cell at position pos = (x,y) in a board of boardSizeX by boardSizeY
     *  status of hidden, dug, or flagged
     *  maintains count of neighboring bombs
     *  contains either a bomb or not
     * 
     * Rep Invariant:
     *  neighborBombs >= 0
     *  pos.getX() < boardSizeX
     *  pos.getY() < boardSizeY
     *  
     * Exposure:
     *  private final fields or final immutable statics
     *  all methods return immutable objects
     * 
     * Thread Safety:
     *  using monitor pattern, all methods locked by this
     * 
     */
    
    private Boolean bomb;
    private String viewStatus;
    private int neighborBombs;
    private final Tuple pos;
    private final int boardSizeX;
    private final int boardSizeY;
    
    public static final String STATUS_HIDDEN = "hidden";
    public static final String STATUS_DUG = "dug";
    public static final String STATUS_FLAGGED = "flagged";
        
    /*
     * check representation invariant
     */
    private void checkRep(){
        assert neighborBombs >= 0;
        assert pos.getX() < boardSizeX;
        assert pos.getY() < boardSizeY;
    }
    /**
     * construct this cell
     * 
     * @param sizeX board size
     * @param sizeY board size 
     * @param xCoord position of this 
     * @param yCoord position of this
     */
    public Cell(int sizeX, int sizeY, int xCoord, int yCoord){
        bomb = false;
        viewStatus = STATUS_HIDDEN;
        neighborBombs = 0;
        pos = new Tuple(xCoord, yCoord);
        boardSizeX = sizeX;
        boardSizeY = sizeY;
    }
    
    /**
     * 
     * @return cell status "dug" "hidden" "flagged"
     */
    public synchronized String getStatus(){
        return viewStatus;
    }
    
    /**
     * 
     * @return list of position tuples of neighboring cells
     */
    public synchronized List<Tuple> getNeighbors(){
        List<Tuple> outputPos = new ArrayList<Tuple>();
        for(int i = -1; i <=1; i++){
            for(int j = -1; j<=1; j++){
                int x = pos.getX() + i;
                int y = pos.getY() + j;
                if ((!(x == pos.getX()) || !(y == pos.getY())) && x >= 0 && y >= 0 && x < boardSizeX && y < boardSizeY){
                    outputPos.add(new Tuple(x, y));
                }
                
            }
        }
        checkRep();
        return outputPos;
    }
    
    /**
     * 
     * @return true if bomb made, else not able to do so, hence false
     */
    public synchronized Boolean makeBomb(){
        if (bomb) {return false;}
        else {
            bomb = true;
            checkRep();
            return true;
        }
    }
    
    /**
     * 
     * @return true if unmade or false if not possible
     */
    public synchronized Boolean unMakeBomb(){
        if (bomb) {
            bomb = false;
            checkRep();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @return boolean true if bomb, else false
     */
    public synchronized boolean isBomb(){
        return bomb;
    }
    /**
     * increments neighborBomb count
     */
    public synchronized void addNeighborBomb(){
        neighborBombs++;
        checkRep();
    }
    /**
     * decrement neighborBomb count
     */
    public synchronized void removeNeighborBomb(){
        neighborBombs -= 1;
        checkRep();
    }
    
    /**
     * 
     * @return number of neighboring bombs
     */
    public synchronized int getNeighborBombs(){
        return neighborBombs;
    }
    
    /**
     * 
     * @return x position
     */
    public synchronized int getX(){
        return pos.getX();
    }
    
    /**
     * 
     * @return y position
     */
    public synchronized int getY(){
        return pos.getY();
    }
    
    /**
     * flags this cell if possible based on game rules
     * @return true if flagged, else false
     */
    public synchronized Boolean flag(){
        if(viewStatus == STATUS_FLAGGED){return false;}
        else if (viewStatus == STATUS_HIDDEN) {
            viewStatus = STATUS_FLAGGED;
            return true;
        }
        checkRep();
        return false;
    }
    
    /**
     * unflags if possible based on game rules
     * @return true if flagged, else false
     */
    public synchronized Boolean unflag(){
        if (viewStatus == STATUS_FLAGGED){
            viewStatus = STATUS_HIDDEN;
            return true;
        }
        checkRep();
        return false;
    }
    
    /**
     * changes this cell's status to unhidden unless bomb.
     * @return true to continue revealing if no neighboring bombs, else false and no more cells should be revealed
     */
    public synchronized Boolean reveal(){
        boolean continueRevealing = false;
        if (! bomb){
            if (viewStatus==STATUS_HIDDEN){
                viewStatus = STATUS_DUG;
                if (neighborBombs == 0) {
                    continueRevealing = true;
                }
            }
        }
        checkRep();
        return continueRevealing;
    }
    
    @Override
    public synchronized String toString(){
        final String space = " ";
        final String hyphen = "-";
        final String flagged = "F";
        final String error = "e";
        
        String output;
        if (viewStatus == STATUS_HIDDEN){
            output = hyphen;
        } else if (viewStatus == STATUS_DUG && neighborBombs == 0){
            output = space;
        } else if (viewStatus == STATUS_DUG && neighborBombs > 0){
            output = String.valueOf(neighborBombs);
        } else if (viewStatus == STATUS_FLAGGED){
            output = flagged;
        } else {
            output = error;
        }
        return output;
    }
    
    @Override
    public synchronized boolean equals(Object that){
        if (!(that instanceof Cell)) return false;
        Cell thatCell = (Cell) that;
        return bomb == thatCell.isBomb() && 
                viewStatus == thatCell.getStatus() && 
                neighborBombs == thatCell.getNeighborBombs() && 
                pos.getX() == thatCell.getX() && 
                pos.getY() == thatCell.getY();        
    }
    
}

