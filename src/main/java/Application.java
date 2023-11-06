import java.util.Scanner;

public class Application {
    Scanner sc = new Scanner(System.in);

    void boot(){
        System.out.println(" == 명언 앱 ==");
        System.out.print("명령) ");
        sc.nextLine();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.boot();
    }
}
