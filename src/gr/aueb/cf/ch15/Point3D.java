package gr.aueb.cf.ch15;

/**
 * Point3D Class that extends the Point2D Class
 *
 * @author D1MK4L
 */
public class Point3D extends Point2D {
    private double z;

    public Point3D() {

    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "3D Point (" + getX() + " , " + getY() + " , " +
                z + ") , with Distance From Origin: D = " + getDistanceFromOrigin();
    }

    /**
     * Override the getDistanceFromOrigin from the Point2D Class
     * @return      The Distance from the 0 point(Origin)
     */
    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(Math.pow(super.getDistanceFromOrigin(),2) + (Math.pow(z,2)));
    }
}
