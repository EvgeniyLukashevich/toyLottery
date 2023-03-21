package MVP;

import Toys.BaseToy;

import java.util.ArrayList;

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

}
