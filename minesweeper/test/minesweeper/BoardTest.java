/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests for board
 */
public class BoardTest {
    
    /*
     * Testing Strategy:
     *  addBomb
     *  dig
     *  flag
     *  unflag
     *  toString
     *  
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testAddBomb(){
        Board b = new Board(4,4);
        assertTrue("expected bomb added", b.addBomb(1, 1));
    }
    
    @Test
    public void testDigOnBomb(){
        Board b = new Board(3,3);
        b.addBomb(1, 1);
        assertTrue("expected bomb!", b.dig(1, 1));
    }
    
    @Test
    public void testDigNextToBomb(){
        Board b = new Board(5,5);
        b.addBomb(0, 0);
        b.addBomb(4, 4);
        assertFalse("not expect bomb", b.dig(1, 1));
    }
    
    @Test
    public void testFlag(){
        Board b = new Board(2,2);
        b.flag(0, 0);
        assertTrue("expected F in first spot", b.toString().charAt(0)=='F');
    }
    
    @Test
    public void testToString(){
        Board b = new Board(1,1);
        assertTrue("length larger than 0", b.toString().length()>0);
    }
    
    @Test
    public void testEquals(){
        Board b = new Board(2,2);
        Board c = new Board(2,2);
        assertTrue(b.equals(c));
    }
    
}
