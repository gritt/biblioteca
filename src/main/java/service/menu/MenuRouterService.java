package service.menu;

import entity.Library;
import io.Reader;
import io.Writer;
import service.LibraryService;

public class MenuRouterService extends MenuService {

    private LibraryService libraryService;

    public MenuRouterService(Writer writer, Reader reader) {

        super(writer, reader);

        /*
         * init library service with some books
         */

        // TODO @gritt, refactor where does books source, best fit might not be LibraryService.getBooks()
        libraryService = new LibraryService();

        libraryService.setLibrary(
                new Library(LibraryService.getBooks())
        );
    }

    public boolean handle() {

        int option = getMenuOptionFromStdin();

        switch (option) {

            case 1: {
                String response = libraryService.listBooks();
                writer.print(response);
                return true;
            }
            case 2: {
                String response = libraryService.listReservations();
                writer.print(response);
                return true;
            }
            case 3: {
                int targetBookId = getNumberOptionFromStdin();

                String response = "Sorry, that book is unavailable.\n";
                if (libraryService.checkoutBook(targetBookId)) {
                    response = "Thank yoy! Enjoy the book.\n";
                }

                writer.print(response);
                return true;
            }
            case 4: {
                int targetBookId = getNumberOptionFromStdin();

                String response = "That's not a valid book to return.\n";
                if (libraryService.returnBook(targetBookId)) {
                    response = "Thank you for returning the book.\n";
                }

                writer.print(response);
                break;
            }
            case 0: {
                writer.print("Bye Bye! \n");
                appShouldKeepRunning = false;
                break;
            }
            default: {
                return true;
            }
        }

        return appShouldKeepRunning;
    }

    private int getMenuOptionFromStdin() {
        try {

            int targetOption = reader.readNumber();

            for (Option menuOption : options) {
                if (menuOption.getId() == targetOption) {
                    writer.print("........................"+menuOption.getName()+"........................");
                    return targetOption;
                }
            }

            throw new IndexOutOfBoundsException("Invalid option, please try again");

        } catch (Exception e) {
            writer.print("Invalid option, please try again: ");
            return getMenuOptionFromStdin();
        }
    }

    private int getNumberOptionFromStdin() {
        try {

            return reader.readNumber();

        } catch (Exception e) {
            writer.print("Invalid option, please try again: ");
            return getNumberOptionFromStdin();
        }
    }
}
