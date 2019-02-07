import entity.Book;
import io.Reader;
import service.Library;
import service.Welcome;
import service.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Reader ioReader = new Reader(System.in);
        Menu menuService = new Menu(System.out);
        Welcome welcomeService = new Welcome(System.out);

        Library libraryService = new Library(
                new entity.Library(getBooks()),
                System.out,
                System.in
        );

        welcomeService.show();

        int status = Menu.CONTINUE;

        do {
            try {
                menuService.show();

                status = libraryService.execute(
                        menuService.getAction(ioReader.readNumber())
                );

            } catch (Exception e) {
                // continue
            }

        } while (status == Menu.CONTINUE);

        System.exit(0);
    }

    private static List<Book> getBooks() {

        List<Book> books = new ArrayList<>();

        Book designPatterns = new Book()
                .setId(0)
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setId(1)
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setId(2)
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book commandLineKungFu = new Book()
                .setId(3)
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setYear(2014);

        Book dataScienceFromScratch = new Book()
                .setId(4)
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book pythonTheBible = new Book()
                .setId(5)
                .setName("Python, The Bible")
                .setAuthor("Maurice J. Thompson")
                .setYear(2018);

        books.add(designPatterns);
        books.add(cleanCode);
        books.add(theCleanCoder);
        books.add(commandLineKungFu);
        books.add(dataScienceFromScratch);
        books.add(pythonTheBible);

        return books;
    }
}
