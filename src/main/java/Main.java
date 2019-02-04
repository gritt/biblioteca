import service.GreetingPrinter;

public class Main {

    public static void main(String[] args) {

        GreetingPrinter greetingPrinter = new GreetingPrinter(System.out);

        greetingPrinter.printWelcome();




        //presenter.print("Hello World");
    }
}
