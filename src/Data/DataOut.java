package Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Toys.BaseToy;
import Winners.Winner;

public class DataOut extends Data {

    public DataOut() {
        new Data();
    }

    @Override
    public ArrayList<BaseToy> readToys() throws IOException {
        ArrayList<BaseToy> toyList = new ArrayList<BaseToy>();
        File file = new File(super.toysPath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] list = line.split(";");
            BaseToy toy = new BaseToy(list[1]);
            toy.setId(Integer.parseInt(list[0]));
            toy.setCount(Integer.parseInt(list[2]));
            toy.setRarity(Integer.parseInt(list[3]));
            toyList.add(toy);
        }
        return toyList;
    }

    @Override
    public ArrayList<Winner> readWinners() throws IOException {
        ArrayList<BaseToy> toyList = this.readToys();
        ArrayList<Winner> winnerList = new ArrayList<Winner>();
        File file = new File(super.winnersPath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] list = line.split(";");
            Winner winner = new Winner(list[1]);
            winner.setId(Integer.parseInt(list[0]));
            for (BaseToy toy : toyList) {
                if (toy.getId() == Integer.parseInt(list[2])) {
                    winner.setToy(toy);
                }
            }
            winner.setStatus(Boolean.parseBoolean(list[3]));
            winnerList.add(winner);
        }
        return winnerList;
    }
}
