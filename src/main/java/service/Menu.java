package service;

import io.Presenter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Presenter presenter;
    private List<MenuOption> menuOptions = new ArrayList<>();


    public Menu(PrintStream printStream) {
        this.presenter = new Presenter(printStream);

        MenuOption listBooks = new MenuOption(1, "listBooks", "List Books");

        menuOptions.add(listBooks);
    }

    public void show() {

        StringBuilder listOfOptions = new StringBuilder();

        menuOptions.forEach(menuOption -> {
            listOfOptions.append(menuOption.toString() + "\n");
        });

        listOfOptions.append("\nPlease chose an option [number]: ");

        presenter.print(listOfOptions.toString());
    }

    public String getAction(int number) throws IndexOutOfBoundsException {

        if (number > menuOptions.size() || number < 0) {
            throw new IndexOutOfBoundsException("Invalid option given, please try again \n");
        }

        MenuOption menuOption = menuOptions.get(number);
        return menuOption.getMethod();
    }
}
