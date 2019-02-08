package menu;

import io.Writer;

import java.io.PrintStream;

import java.util.List;

public class MenuBuilder {

    private Writer writer;
    private List<Option> menuOptions;

    public MenuBuilder(List<Option> menuOptions, PrintStream printStream) {
        this.writer = new Writer(printStream);
        this.menuOptions = menuOptions;
    }

    public void show() {

        StringBuilder listOfOptions = new StringBuilder();

        listOfOptions.append("________________________________________\n");

        menuOptions.forEach(option -> {
            listOfOptions.append(option.toString() + "\n");
        });

        writer.print(listOfOptions.toString());
    }
}
