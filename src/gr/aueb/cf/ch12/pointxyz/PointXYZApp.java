package gr.aueb.cf.ch12.pointxyz;

/**
 * Sets 3-dimensional points and
 * call the convertToString to
 * display those points
 *
 * @author D1MK4L
 */
public class PointXYZApp {

    public static void main(String[] args) {
        PointXYZ point1 = new PointXYZ(2, 5, 6);
        PointXYZ point2 = new PointXYZ(1, 2, 3);

        System.out.println(point1.convertToString());
        System.out.println(point2.convertToString());
    }

}
