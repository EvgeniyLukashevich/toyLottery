package MVP.View;

import java.util.Scanner;

public class ViewConsole extends View {

    public ViewConsole() {
        this.showFirstMessage();
    }

    public void showFirstMessage() {
        System.out.println(super.firstMessage());
    }

    public void showMainMenu() {
        System.out.println(super.mainMenu());
    }

    public void showToys(String toysString) {
        System.out.println(toysString);
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    // Добавить игрушку
    public void showAddToyName() {
        System.out.println(super.addToyName());
    }

    public void showAddToyCount() {
        System.out.println(super.addToyCount());
    }

    public void showAddToyRarity() {
        System.out.println(super.addToyRarity());
    }

    public void showAddToyFinal() {
        System.out.println(super.addToyFinal());
    }


    // Изменить количество
    public void showChangeCountFirst() {
        System.out.println(super.changeCountFirst());
    }

    public void showChangeCountSecond() {
        System.out.println(super.changeCountSecond());
    }

    public void showChangeCountFinal() {
        System.out.println(super.changeCountFinal());
    }


    // Розыгрыш
    public void showLotteryFirst() {
        System.out.println(super.lotteryFirst());
    }

    public void showLotterySecond() {
        System.out.println(super.lotterySecond());
    }

    public void showLotteryFinal(String winnerName, String toyName) {
        System.out.println(super.lotteryFinal(winnerName, toyName));
    }


    // Выдача игрушек
    public void showWinners(String winnersString) {
        System.out.println(winnersString);
    }

    public void showReleaseFirst() {
        System.out.println(super.releaseFirst());
    }

    public void showReleaseFinal(String winnerName, String toyName) {
        System.out.println(super.releaseFinal(winnerName, toyName));
    }


    // Посмотреть игрушки, участников
    public void showSeparator() {
        System.out.println(super.Separator());
    }


    // Ошибка ввода
    public void showInputError() {
        System.out.println(super.inputError());
    }

}
