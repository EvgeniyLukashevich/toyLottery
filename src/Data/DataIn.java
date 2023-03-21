package Data;

import Toys.BaseToy;
import Winners.Winner;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;


public class DataIn extends Data {

    public DataIn() {
        new Data();
    }

    @Override
    public void writeToys(ArrayList<BaseToy> toyList) throws IOException {
        File file = new File(super.toysPath);
        FileWriter writer = new FileWriter(file);
        StringBuilder text = new StringBuilder();
        for (BaseToy toy : toyList) {
            text.append(toy.getId()).append(";")
                    .append(toy.getName()).append(";")
                    .append(toy.getCount()).append(";")
                    .append(toy.getRarity()).append("\n");
        }
        writer.write(text.toString());
        writer.close();
    }

    @Override
    public void writeWinners(ArrayList<Winner> winnerList) throws IOException {
        File file = new File(this.winnersPath);
        FileWriter writer = new FileWriter(file);
        StringBuilder text = new StringBuilder();
        for (Winner winner : winnerList) {
            text.append(winner.getId()).append(";")
                    .append(winner.getName()).append(';')
                    .append(winner.getToy().getId()).append(";")
                    .append(winner.getStatus()).append("\n");
        }
        writer.write(text.toString());
        writer.close();

    }
}
