package service;

import entity.MenuOption;
import io.Writer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static int CONTINUE = -1;
    public static int QUIT = 0;

    private Writer writer;
    private List<MenuOption> menuOptions = new ArrayList<>();


    public Menu(PrintStream printStream) {
        this.writer = new Writer(printStream);

        MenuOption listBooks = new MenuOption(0, "listBooks", "List Books");
        MenuOption checkoutBook = new MenuOption(1, "checkoutBook", "Checkout Book");
        MenuOption closeApp = new MenuOption(2, "close", "Close");

        menuOptions.add(listBooks);
        menuOptions.add(checkoutBook);
        menuOptions.add(closeApp);
    }

    public void show() {

        StringBuilder listOfOptions = new StringBuilder();

        menuOptions.forEach(menuOption -> {
            listOfOptions.append(menuOption.toString() + "\n");
        });

        listOfOptions.append("\nPlease select a valid menu option [number]: ");

        writer.print(listOfOptions.toString());
    }

    public String getAction(int number) throws IndexOutOfBoundsException {

        if (number > menuOptions.size() || number < 0) {
            throw new IndexOutOfBoundsException("Invalid option given\n");
        }

        MenuOption menuOption = menuOptions.get(number);
        return menuOption.getMethod();
    }
}
