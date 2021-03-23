package Model;

/*@author Rizki Ramadandi*/
public class Category {

    private String id, name, label;

    public Category(String id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
