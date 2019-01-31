package minesweeper;

/**
 * Immutable x,y pair called a tuple.
 * Threadsafe data-type.
 */
public class Tuple {
    //simple tuple function
    //threadsafe due to immutability
    
    private final int x;
    private final int y;
    public Tuple(int x1, int y1){
        x = x1;
        y = y1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public boolean equals(Object that){
        if (! (that instanceof Tuple)) return false;
        Tuple thatTuple = (Tuple) that;
        return thatTuple.getX() == x && thatTuple.getY() == y;
    }
    
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    
    @Override
    public int hashCode(){
        return x * y;
    }
}
