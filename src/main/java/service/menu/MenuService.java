package service.menu;

import io.Reader;
import io.Writer;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    protected Writer writer;
    protected Reader reader;

    protected List<Option> options = new ArrayList<>();

    public MenuService(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;

        options.add(new Option(1, "List books"));
        options.add(new Option(2, "List reservations"));
        options.add(new Option(3, "Checkout a book"));
        options.add(new Option(4, "Return a book"));
        options.add(new Option(0, "Close"));
    }
}
