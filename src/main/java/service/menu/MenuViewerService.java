package service.menu;

import io.Reader;
import io.Writer;

public class MenuViewerService extends MenuService {

    public MenuViewerService(Writer writer, Reader reader) {
        super(writer, reader);
    }

    public void view() {

        StringBuilder listOfOptions = new StringBuilder();

        listOfOptions.append("........................Chose one option from below........................\n");

        options.forEach(option -> {
            listOfOptions.append(option.toString() + "\n");
        });

        writer.print(listOfOptions.toString());
    }
}
