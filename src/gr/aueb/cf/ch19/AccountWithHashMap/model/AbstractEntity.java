package gr.aueb.cf.ch19.AccountWithHashMap.model;

public class AbstractEntity implements AccountIDEntity {
    private Long id;
    private static Long nextId=1L;

    public AbstractEntity() {this.id = nextId++;}

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
