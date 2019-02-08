import entity.Book;
import service.Welcome;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Welcome welcomeService = new Welcome(System.out);
        welcomeService.show();

//        Reader ioReader = new Reader(System.in);
//        Menu menuService = new Menu(System.out);

//        Library libraryService = new Library(
//                new entity.Library(getBooks()),
//                System.out,
//                System.in
//        );
//
//
//        int status = Menu.CONTINUE;
//
//        do {
//            try {
//                menuService.show();
//
//                status = libraryService.execute(
//                        menuService.getAction(ioReader.readNumber())
//                );
//
//            } catch (Exception e) {
//                 continue
//            }
//
//        } while (status == Menu.CONTINUE);
//
//        System.exit(0);
    }

    private static List<Book> getBooks() {

        List<Book> books = new ArrayList<>();

        Book designPatterns = new Book()
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book commandLineKungFu = new Book()
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setYear(2014);

        Book dataScienceFromScratch = new Book()
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book pythonTheBible = new Book()
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
