import io.Reader;
import service.Library;
import service.Welcome;
import service.Menu;

public class Main {

    public static void main(String[] args) {

        Welcome welcome = new Welcome(System.out);
        welcome.show();

        Library library = new Library(
                new entity.Library(),
                System.out
        );


        Menu menu = new Menu(System.out);
        Reader reader = new Reader(System.in);

        int status = Menu.CONTINUE;
        do {
            try {
                menu.show();

                status = library.execute(
                        menu.getAction(reader.readNumber())
                );

            } catch (Exception e) {
                continue;
            }

        } while (status == Menu.CONTINUE);

        System.exit(0);
    }
}
