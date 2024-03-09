package gr.aueb.cf.ch16.hm2;

public class Circle extends AbstractShape implements ICircle{
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

    @Override
    public double getArea() {
        return Math.PI * radius;
    }

    @Override
    public long getCircumference() {
        return (long) ((2*Math.PI)*radius);
    }

    @Override
    public double getDiameter() {
        return getCircumference()/Math.PI;
    }

    @Override
    public long getId() {
        return 0;
    }
}
