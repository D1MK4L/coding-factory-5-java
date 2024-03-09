package gr.aued.cf.homeworks.ch17.Hm1;

public class Main {

    public static void main(String[] args) {


        Line line = new Line(1,4);
        System.out.print("length is: " + line.getLength()+"\n");
        RectAngle rectangle = new RectAngle(2, 4, 5);
        System.out.print("Area is: "+rectangle.Area()+"\n");
        Circle circle = new Circle(3,5);
        System.out.print("Area is: "+circle.Area());

    }
}
