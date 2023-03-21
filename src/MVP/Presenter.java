package MVP;

import Data.Data;
import Data.DataIn;
import Data.DataOut;
import MVP.View.ViewConsole;
import Toys.BaseToy;
import Winners.Winner;

import java.io.IOException;
import java.util.ArrayList;

public class Presenter {
    String welcomeMessage = "Добро пожаловать!\n";
    public Presenter() {
        System.out.println(this.welcomeMessage);
    }

    public void start() throws IOException {
        boolean stop = false;
        while (!stop) {
            // Подгружаем данные
            Data dataOut = new DataOut();
            ArrayList<BaseToy> toyList = dataOut.readToys();
            ArrayList<Winner> winnerList = dataOut.readWinners();
            Data dataIn = new DataIn();
            Model model = new Model();
            // Начинаем работу в консоли
            ViewConsole view = new ViewConsole();
            view.showMainMenu();
            String mainInput = view.userInput();

            // Добавить игрушку
            if (mainInput.equals("1")) {
                // Название игрушки
                view.showAddToyName();
                String toyName = view.userInput();
                // Количество
                view.showAddToyCount();
                String toyCount = view.userInput();
                boolean check = model.addToyCheckCount(toyCount);
                while (!check) {
                    view.showInputError();
                    view.showAddToyCount();
                    toyCount = view.userInput();
                    check = model.addToyCheckCount(toyCount);
                }
                // Ценность
                view.showAddToyRarity();
                String toyRarity = view.userInput();
                check = model.addToyCheckRarity(toyRarity);
                while (!check) {
                    view.showInputError();
                    view.showAddToyRarity();
                    toyRarity = view.userInput();
                    check = model.addToyCheckRarity(toyRarity);
                }
                // ID
                Integer toyId = model.offerToyId(toyList);
                // Сборка
                BaseToy toy = new BaseToy(toyName);
                toy.setId(toyId);
                toy.setCount(Integer.parseInt(toyCount));
                toy.setRarity(Integer.parseInt(toyRarity));
                toyList.add(toy);
                dataIn.writeToys(toyList);
                view.showAddToyFinal();
            }

            // Изменить количество
            else if (mainInput.equals("2")) {
                view.showToys(model.AllToys(toyList));
                view.showChangeCountFirst();
                String toyId = view.userInput();
                boolean check = model.checkId(toyId, toyList);
                while (!check) {
                    view.showInputError();
                    view.showChangeCountFirst();
                    toyId = view.userInput();
                    check = model.checkId(toyId, toyList);
                }
                view.showChangeCountSecond();
                String newCount = view.userInput();
                check = model.addToyCheckCount(newCount);
                while (!check) {
                    view.showInputError();
                    view.showChangeCountSecond();
                    newCount = view.userInput();
                    check = model.addToyCheckCount(newCount);
                }
                int i = 0;
                for (BaseToy toy:toyList){
                    if (toy.getId().equals(Integer.parseInt(toyId))){
                        toyList.get(i).setCount(Integer.parseInt(newCount));
                        break;
                    }
                    i++;
                }
                dataIn.writeToys(toyList);
                view.showChangeCountFinal();
            }

            // Провести розыгрыш
            else if (mainInput.equals("3")) {
                view.showLotteryFirst();
                String name = view.userInput();

            }

            // Выдать игрушку
            else if (mainInput.equals("4")) {

            }

            // Показать игрушки
            else if (mainInput.equals("5")) {
                view.showSeparator();
                view.showToys(model.AllToys(toyList));
                view.showSeparator();
            }

            // Показать участников
            else if (mainInput.equals("6")) {

            }

            // Выход
            else if (mainInput.equals("0")) {
                stop = true;
            }

            // Ошибка ввода
            else {
                view.showInputError();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Presenter presenter = new Presenter();
        presenter.start();
    }
}
