package service;

public class MenuOption {

    private int id;
    private String method;
    private String parameter;

    public MenuOption(int id, String method, String parameter) {
        this.id = id;
        this.method = method;
        this.parameter = parameter;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getParameter() {
        return parameter;
    }
}
