package MVP.View;

import java.util.Scanner;

public class ViewConsole extends View {

    public void showMainMenu() {
        System.out.println(super.mainMenu());
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
