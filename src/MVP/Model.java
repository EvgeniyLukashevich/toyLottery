package MVP;

import Toys.BaseToy;
import Winners.Winner;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    public Model() {
    }


    // Добавить игрушку
    public boolean addToyCheckCount(String userInput) {
        try {
            int count = Integer.parseInt(userInput);
            return count >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean addToyCheckRarity(String userInput) {
        try {
            int rarity = Integer.parseInt(userInput);
            return rarity >= 1 && rarity <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Integer offerToyId(ArrayList<BaseToy> toyList) {
        if (toyList.isEmpty()) {
            return 1;
        } else {
            BaseToy lastToy = toyList.get(toyList.size() - 1);
            return lastToy.getId() + 1;
        }
    }


    // Изменить количество
    public String AllToys(ArrayList<BaseToy> toyList) {
        StringBuilder text = new StringBuilder();
        for (BaseToy toy : toyList) {
            text.append("id: ").append(toy.getId()).append("\n")
                    .append("Название: ").append(toy.getName()).append("\n")
                    .append("Количество: ").append(toy.getCount()).append("\n");
            if (toy.getRarity().equals(3)) {
                text.append("Ценность: ").append("антиквариат").append("\n\n");
            } else if (toy.getRarity().equals(2)) {
                text.append("Ценность: ").append("раритет").append("\n\n");
            } else {
                text.append("Ценность: ").append("ценная").append("\n\n");
            }
        }
        return text.toString();
    }

    public boolean checkId(String userInput, ArrayList<BaseToy> toyList) {
        try {
            int id = Integer.parseInt(userInput);
            for (int i = 0; i < toyList.size(); i++) {
                BaseToy toy = toyList.get(i);
                if (id == toy.getId()) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }


    // Розыгрыш
    public BaseToy lottery(ArrayList<BaseToy> toyList) {
        ArrayList<Integer> chanceList = new ArrayList<Integer>();
        Random random = new Random();
        ArrayList<BaseToy> firstRarityToys = new ArrayList<BaseToy>();
        ArrayList<BaseToy> secondRarityToys = new ArrayList<BaseToy>();
        ArrayList<BaseToy> thirdRarityToys = new ArrayList<BaseToy>();

        for (BaseToy toy : toyList) {
            if (toy.getRarity().equals(1) && toy.getCount() > 0) {
                firstRarityToys.add(toy);
            } else if (toy.getRarity().equals(2) && toy.getCount() > 0) {
                secondRarityToys.add(toy);
            } else if (toy.getRarity().equals(3) && toy.getCount() > 0) {
                thirdRarityToys.add(toy);
            }
        }
        if (firstRarityToys.isEmpty() &&
                secondRarityToys.isEmpty() &&
                thirdRarityToys.isEmpty()) {
            return null;
        }
        if (!firstRarityToys.isEmpty()) {
            chanceList.add(1);
            chanceList.add(1);
            chanceList.add(1);
        }
        if (!secondRarityToys.isEmpty()) {
            chanceList.add(2);
            chanceList.add(2);
        }
        if (!thirdRarityToys.isEmpty()) {
            chanceList.add(3);
        }
        Integer rarity = chanceList.get(random.nextInt(chanceList.size()));
        BaseToy toy = new BaseToy("Утешительная игрушка");
        if (rarity.equals(3)) {
            int index = random.nextInt(thirdRarityToys.size());
            toy = thirdRarityToys.get(index);
        } else if (rarity.equals(2)) {
            int index = random.nextInt(secondRarityToys.size());
            toy = secondRarityToys.get(index);
        } else {
            int index = random.nextInt(firstRarityToys.size());
            toy = firstRarityToys.get(index);
        }
        return toy;
    }

    public Integer offerWinnerId(ArrayList<Winner> winnerList) {
        if (winnerList.isEmpty()) {
            return 1;
        } else {
            Winner lastWinner = winnerList.get(winnerList.size() - 1);
            return lastWinner.getId() + 1;
        }
    }


    // Выдача игручшки
    public ArrayList<Winner> winnersWithoutToy(ArrayList<Winner> winnerList) {
        ArrayList<Winner> newWinnerList = new ArrayList<Winner>();
        for (Winner winner : winnerList) {
            if (winner.getStatus().equals(false)) {
                newWinnerList.add(winner);
            }
        }
        return newWinnerList;
    }

    public boolean checkWinnerId(String userInput, ArrayList<Winner> winnerList) {
        try {
            int id = Integer.parseInt(userInput);
            for (int i = 0; i < winnerList.size(); i++) {
                Winner winner = winnerList.get(i);
                if (id == winner.getId()) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public String winnersString(ArrayList<Winner> winnerList) {
        StringBuilder text = new StringBuilder();
        for (Winner winner : winnerList) {
            text.append("id: ").append(winner.getId()).append("\n")
                    .append("Имя: ").append(winner.getName()).append("\n")
                    .append("Игрушка: ").append(winner.getToy().getName()).append("\n");
            if (winner.getStatus().equals(true)) {
                text.append("Статус: ").append("игрушка ВЫДАНА").append("\n\n");
            } else {
                text.append("Статус: ").append("игрушка НЕ ВЫДАНА").append("\n\n");
            }
        }
        return text.toString();
    }
}
