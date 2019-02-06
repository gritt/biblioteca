package service;

public class MenuOption {

    private int id;
    private String method;
    private String name;

    public MenuOption(int id, String method, String name) {
        this.id = id;
        this.method = method;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + "\n";
    }

    public String getMethod() {
        return method;
    }
}
