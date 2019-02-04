import io.Presenter;

public class Main {

    public static void main(String[] args) {

        // setup presenter class for stdout
        Presenter presenter = new Presenter(System.out);

        // setup reader class for stdin

        presenter.print("Hello World");

        //presenter.print("Hello World");
    }
}
