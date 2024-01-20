package gr.aueb.cf.ch15;
/**
 * Point2D Class that extends the Point Class
 *
 * @author D1MK4L
 */
public class Point2D extends Point {
    private double y;

    public Point2D() {

    }

    public Point2D(double y) {
        this.y = y;
    }

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "2D Point (" +getX()+
                " , " + y + ") , with Distance From Origin: D = " + getDistanceFromOrigin();
    }

    /**
     * Override the getDistanceFromOrigin from the Point Class
     * @return      The Distance from the 0 point(Origin)
     */
    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(super.getDistanceFromOrigin(),2)+
                Math.pow(y,2));
    }
}
