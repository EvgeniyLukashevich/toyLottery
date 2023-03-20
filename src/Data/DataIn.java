package Data;

import Toys.BaseToy;
import Winners.Winner;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;


public class DataIn extends Data {

    public DataIn(){
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

    public static void main(String[] args) throws IOException {

        Data dataOut = new DataOut();
        Data dataIn = new DataIn();
        ArrayList<BaseToy> toyList = dataOut.readToys();
        ArrayList<Winner> winnerList = dataOut.readWinners();

        BaseToy toy1 = new BaseToy("cat");
        toy1.setId(1);
        toy1.setCount(5);
        toy1.setRarity(3);

        BaseToy toy2 = new BaseToy("wolf");
        toy2.setId(2);
        toy2.setCount(14);
        toy2.setRarity(2);

        toyList.add(toy1);
        toyList.add(toy2);


        dataIn.writeToys(toyList);
        Winner w1 = new Winner("Petya");
        w1.setId(1);
        w1.setToy(toy2);
        winnerList.add(w1);
        dataIn.writeWinners(winnerList);
    }

}
