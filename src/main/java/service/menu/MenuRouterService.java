package service.menu;


import io.Reader;
import io.Writer;

public class MenuRouterService extends MenuService{

    public MenuRouterService(Writer writer, Reader reader) {
        super(writer, reader);
    }

    public boolean handle() {

        int option = getMenuOptionFromStdin();

//        menuOptions.add(new Option(1, "List books"));
//        menuOptions.add(new Option(2, "List reservations"));
//        menuOptions.add(new Option(3, "Checkout a book"));
//        menuOptions.add(new Option(4, "Return a book"));
//        menuOptions.add(new Option(0, "Close"));

        return false;
    }

    private int getMenuOptionFromStdin() {
        try {

            int targetOption = reader.readNumber();

            for (Option menuOption : options) {
                if (menuOption.getId() == targetOption) {
                    writer.print(menuOption.toString());
                    return targetOption;
                }
            }

            throw new IndexOutOfBoundsException("Invalid option, please try again");

        } catch (Exception e) {
            writer.print("Invalid option, please try again: ");
            return getMenuOptionFromStdin();
        }
    }
}
