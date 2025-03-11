// File Name : Point.java
public class Point {
    private int x = 10; // x part of coordinate pair
    private int y = 10; // y part of coordinate pair
    private static int count = 0;

    // No-argument constructor
    public Point() {
        setX(0);
        setY(0);
        count++;
    }

    // Constructor with parameters
    public Point(int xValue, int yValue) {
        setX(xValue);
        setY(yValue);
        count++;
    }

    // Finalizer
    protected void finalize() {
        count--;
    }

    // Set x in coordinate pair
    public void setX(int xValue) {
        x = xValue; // No need for validation
    }

    // Return x from coordinate pair
    public int getX() {
        return x;
    }

    // Set y in coordinate pair
    public void setY(int yValue) {
        y = yValue; // No need for validation
    }

    // Return y from coordinate pair
    public int getY() {
        return y;
    }

    // Return the count of Point instances
    public static int getCount() {
        return count;
    }

    // Return String representation of Point object
    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }
} // End class Point
