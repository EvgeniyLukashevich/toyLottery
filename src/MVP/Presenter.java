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
                view.showAddToyName();
                String toyName = view.userInput();
                view.showAddToyCount();
                String toyCount = view.userInput();
                boolean check = model.addToyCheckCount(toyCount);
                while (!check) {
                    view.showInputError();
                    view.showAddToyCount();
                    toyCount = view.userInput();
                    check = model.addToyCheckCount(toyCount);
                }
                view.showAddToyRarity();
                String toyRarity = view.userInput();
                check = model.addToyCheckRarity(toyRarity);
                while (!check) {
                    view.showInputError();
                    view.showAddToyRarity();
                    toyRarity = view.userInput();
                    check = model.addToyCheckRarity(toyRarity);
                }
                Integer toyId = model.offerToyId(toyList);
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
                for (BaseToy toy : toyList) {
                    if (toy.getId().equals(Integer.parseInt(toyId))) {
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
                if (model.lottery(toyList) == null) {
                    view.showLotterySecond();
                } else {
                    BaseToy userToy = model.lottery(toyList);
                    int i = 0;
                    for (BaseToy toy : toyList) {
                        if (toy.getId().equals(userToy.getId())) {
                            toyList.get(i).setCount(toy.getCount() - 1);
                            break;
                        }
                        i++;
                    }
                    Integer winnerId = model.offerWinnerId(winnerList);
                    Winner winner = new Winner(name);
                    winner.setId(winnerId);
                    winner.setToy(userToy);
                    winner.setStatus(false);
                    winnerList.add(winner);
                    dataIn.writeToys(toyList);
                    dataIn.writeWinners(winnerList);
                    view.showLotteryFinal(name, userToy.getName());
                }
            }

            // Выдать игрушку
            else if (mainInput.equals("4")) {
                ArrayList<Winner> winnersWithoutToys = model.winnersWithoutToy(winnerList);
                view.showWinners(model.winnersString(winnersWithoutToys));
                view.showReleaseFirst();
                String winnerId = view.userInput();
                boolean check = model.checkWinnerId(winnerId, winnersWithoutToys);
                while (!check) {
                    view.showInputError();
                    view.showReleaseFirst();
                    winnerId = view.userInput();
                    check = model.checkWinnerId(winnerId, winnerList);
                }
                int i = 0;
                for (Winner winner : winnerList) {
                    if (winner.getId() == Integer.parseInt(winnerId)) {
                        winnerList.get(i).setStatus(true);
                        break;
                    }
                    i++;
                }
                dataIn.writeWinners(winnerList);
                view.showReleaseFinal(winnerList.get(i).getName(),
                        winnerList.get(i).getToy().getName());
            }

            // Показать игрушки
            else if (mainInput.equals("5")) {
                view.showSeparator();
                view.showToys(model.AllToys(toyList));
                view.showSeparator();
            }

            // Показать участников
            else if (mainInput.equals("6")) {
                view.showSeparator();
                view.showWinners(model.winnersString(winnerList));
                view.showSeparator();
            }

            // Выход
            else if (mainInput.equals("0")) {
                stop = true;
            }

            // Ошибка ввода в главном меню
            else {
                view.showInputError();
            }
        }
    }
}
