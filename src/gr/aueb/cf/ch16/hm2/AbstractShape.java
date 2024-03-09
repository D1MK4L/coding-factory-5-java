package gr.aueb.cf.ch16.hm2;

public class AbstractShape implements IShape{
    private long id;

    public AbstractShape() {
    }

    public AbstractShape(long id) {
        this.id = id;
        if (id==1){
            System.out.println("Line");
        }
        if (id==2){
            System.out.println("Rectangle");
        }
        if(id==3){
            System.out.println("Circle");
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return 0;
    }
}
