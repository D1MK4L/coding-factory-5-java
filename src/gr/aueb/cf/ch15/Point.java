package gr.aueb.cf.ch15;

/**
 * A Point
 *
 * @author D1MK4L
 */
public class Point {
    private double x;

    public Point() {
    }

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "1D Point (" + x + ") with Distance from Origin: D = " + getDistanceFromOrigin();
    }

    /**
     * The getDistanceFromOrigin
     * @return      The Distance of a point from the 0 point(Origin)
     */
    public double getDistanceFromOrigin() {
      return  x = this.x - 0;
    }
}
