package gr.aueb.cf.ch16.hm2;

public class Line extends AbstractShape implements ILine{
    private double length;

    public Line(){

    }

    public Line(double length) {
        this.length = length;
    }

    public Line(long id, double length) {
        super(id);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public long getId() {
        return 0;
    }
}
