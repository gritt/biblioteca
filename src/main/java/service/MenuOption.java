package service;

public class MenuOption {

    private int id;
    private String method;

    public MenuOption(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }
}
