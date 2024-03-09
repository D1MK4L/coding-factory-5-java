package gr.aueb.cf.ch16.hm1;

public class RectAngle extends AbstractShape implements ITwoDimensional{
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

    @Override
    public double Area() {
        return width * height;
    }

    @Override
    public long getId() {
        return 0;
    }
}
