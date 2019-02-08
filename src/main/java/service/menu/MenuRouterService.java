package service.menu;

import entity.Book;
import entity.Library;
import io.Reader;
import io.Writer;
import service.LibraryService;

import java.util.HashMap;
import java.util.Map;

public class MenuRouterService extends MenuService {

    private LibraryService libraryService;

    public MenuRouterService(Writer writer, Reader reader) {
        super(writer, reader);
        /*
         * init library service with some books
         */
        libraryService = new LibraryService();

        libraryService.setLibrary(
                new Library(initBooks())
        );
    }

    private Map<Integer, Book> initBooks() {

        Map<Integer, Book> books = new HashMap<Integer, Book>();

        Book designPatterns = new Book()
                .setId(11)
                .setAvailable(true)
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setId(22)
                .setAvailable(true)
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setId(33)
                .setAvailable(true)
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book commandLineKungFu = new Book()
                .setId(44)
                .setAvailable(true)
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setYear(2014);

        Book dataScienceFromScratch = new Book()
                .setId(55)
                .setAvailable(true)
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book pythonTheBible = new Book()
                .setId(66)
                .setAvailable(true)
                .setName("Python, The Bible")
                .setAuthor("Maurice J. Thompson")
                .setYear(2018);

        books.put(designPatterns.getId(), designPatterns);
        books.put(cleanCode.getId(), cleanCode);
        books.put(theCleanCoder.getId(), theCleanCoder);
        books.put(commandLineKungFu.getId(), commandLineKungFu);
        books.put(dataScienceFromScratch.getId(), dataScienceFromScratch);
        books.put(pythonTheBible.getId(), pythonTheBible);

        return books;
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

                String listOfBooks = libraryService.listBooks();
                writer.print(listOfBooks);
                writer.print("Which book do you want to checkout? ");

                int targetBookId = getNumberOptionFromStdin();

                String response = "Sorry, that book is unavailable.\n";
                if (libraryService.checkoutBook(targetBookId)) {
                    response = "Thank yoy! Enjoy the book.\n";
                }

                writer.print(response);
                return true;
            }
            case 4: {

                String listOfReservations = libraryService.listReservations();
                writer.print(listOfReservations);
                writer.print("Which book do you want to return? ");

                int targetBookId = getNumberOptionFromStdin();

                String response = "That's not a valid book to return.\n";
                if (libraryService.returnBook(targetBookId)) {
                    response = "Thank you for returning the book.\n";
                }

                writer.print(response);
                return true;
            }
            case 0: {
                writer.print("Bye Bye! \n");
                return false;
            }
            default: {
                return true;
            }
        }
    }

    private int getMenuOptionFromStdin() {
        try {

            int targetOption = reader.readNumber();

            for (Option menuOption : options) {
                if (menuOption.getId() == targetOption) {
                    writer.print("........................" + menuOption.getName() + "........................");
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
