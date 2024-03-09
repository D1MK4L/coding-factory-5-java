package gr.aued.cf.homeworks.ch17.Hm1;

import java.io.Serializable;

public class RectAngle extends AbstractShape implements ITwoDimensional, Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private double width;
    private double height;

    public RectAngle() {

    }

    public RectAngle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectAngle(long id, double width, double height) {
        super(id);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public RectAngle (RectAngle rectAngle) {
        this.width = rectAngle.getWidth();
        this.height = rectAngle.getHeight();
    }

    @Override
    protected RectAngle clone() throws CloneNotSupportedException {
        RectAngle rectAngle = (RectAngle) super.clone();
        return rectAngle;
    }

    @Override
    public double Area() {
        return width * height;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RectAngle rectAngle = (RectAngle) o;

        if (Double.compare(rectAngle.width, width) != 0) return false;
        return Double.compare(rectAngle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
