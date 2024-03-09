package gr.aueb.cf.ch16.hm1;

public class Circle extends AbstractShape implements ITwoDimensional {
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
    public double Area() {
        return Math.PI * radius;
    }

    @Override
    public long getId() {
        return 0;
    }

}
