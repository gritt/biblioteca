import io.Reader;
import io.Writer;
import service.WelcomeService;
import service.menu.MenuRouterService;
import service.menu.MenuViewerService;

public class Main {

    public static void main(String[] args) {

        WelcomeService welcomeService = new WelcomeService(System.out);

        MenuViewerService menuViewerService = new MenuViewerService(new Writer(System.out), new Reader());
        MenuRouterService menuRouterService = new MenuRouterService(new Writer(System.out), new Reader());

        welcomeService.show();

        boolean appShouldKeepRunning = true;
        do {
            try {

                menuViewerService.view();

                appShouldKeepRunning = menuRouterService.handle();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (appShouldKeepRunning);


        System.exit(0);
    }
}
