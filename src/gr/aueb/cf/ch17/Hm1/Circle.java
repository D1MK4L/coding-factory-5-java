package gr.aueb.cf.ch17.Hm1;

import java.io.Serializable;

public class Circle extends AbstractShape implements ITwoDimensional, Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private double radius;

    public Circle(){

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(long id, double radius) {
        super(id);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Circle (Circle circle) {
        this.radius = circle.getRadius();
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        Circle circle = (Circle) super.clone();
        return  circle;
    }

    @Override
    public double Area() {
        return Math.PI * radius;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }
}
