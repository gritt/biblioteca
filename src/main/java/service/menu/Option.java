package service.menu;

public class Option {

    private int id;
    private String name;

    public Option(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

    public int getId() {
        return id;
    }
}
