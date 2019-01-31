package minesweeper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CellTest {
    /*
     * getNeighbors
     * makeBomb
     * unMakeBomb
     * isBomb
     * addNeighborBomb
     * removeNeighborBomb
     * getNeighborBombs
     * getX
     * getY
     * flag
     * unflag
     * reveal
     * toString
     * 
     */
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testCellGetNeighborsAndPos(){
        Cell c = new Cell(4, 4, 3, 3);
        assertTrue("expected to contain neighbors", c.getNeighbors().containsAll(Arrays.asList(new Tuple(2,2), new Tuple(2,3), new Tuple(3,2))));
        assertTrue("expected to be at 3,3", c.getX()==3 && c.getY()==3);
    }
    
    @Test
    public void testCellMakeBomb(){
        Cell c = new Cell(4,4,3,3);
        assertFalse("expected non bomb", c.isBomb());
        assertTrue("expected to make bomb", c.makeBomb());
        assertTrue("expected bomb", c.isBomb());
        //unmake
        assertTrue("expected to unmake bomb", c.unMakeBomb());
        assertFalse("expected non bomb", c.isBomb());
    }
    
    @Test
    public void testCellAddNeighborBomb(){
        Cell c = new Cell(4,4,3,3);
        assertTrue("expected no bombs", c.getNeighborBombs()==0);
        c.addNeighborBomb();
       
        assertTrue("expected one bomb", c.getNeighborBombs()==1);
        c.removeNeighborBomb();
        assertTrue("expected no bombs", c.getNeighborBombs() == 0);
    }
    
    @Test
    public void testCellFlag(){
        Cell c = new Cell(3,3,1,1);
        c.flag();
        assertTrue("expected stats = flag", c.toString() == "F");
        c.unflag();
        assertTrue("expected unflagged", c.toString()=="-");
    }
    
    @Test
    public void testCellReveal(){
        Cell c = new Cell(4,4,2,2);
        boolean cont = c.reveal();
        assertTrue("expected to continue since no neighbors", cont);
        
        cont = c.reveal();
        assertFalse("expected revealing to stop since not hidden", cont);
        
        Cell c2 = new Cell(4,4,2,2);
        c2.addNeighborBomb();
        assertFalse("expected to not continue revealing since has bomb next door", c2.reveal());
    }
    
    
}
