package gr.aueb.cf.ch17.Hm1;

import java.io.Serializable;

public class Line extends AbstractShape implements Cloneable, Serializable {
    private static final long serialVersionUID = 1;
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

    private Line (Line line) {
        this.length = line.getLength();
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        return line;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Double.compare(line.length, length) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(length);
        return (int) (temp ^ (temp >>> 32));
    }
}
