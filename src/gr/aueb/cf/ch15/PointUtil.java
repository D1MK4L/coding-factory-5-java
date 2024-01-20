package gr.aueb.cf.ch15;

/**
 * Displays a p Point a 2D Point and a 3D Point
 *
 * @author D1MK4L
 */
public class PointUtil {

    public static void main(String[] args) {
        Point p = new Point(2);
        Point2D p2D = new Point2D(2,3);
        Point3D p3D = new Point3D(2,3,4);

        distanceFromOrigin(p);
        distanceFromOrigin(p2D);
        distanceFromOrigin(p3D);


    }

    /**
     * Returns the point
     *
     * @param point The point
     * @return          The Origin
     */
    public static double distanceFromOrigin(Point point) {
        System.out.println(point);
        return 0;
    }
}
