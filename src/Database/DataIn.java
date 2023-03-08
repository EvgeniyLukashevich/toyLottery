package Database;

import Toys.BaseToy;

import java.io.*;
import java.io.IOException;
import java.util.List;


public class DataIn {
    public static void writeToys(BaseToy[] toyList) throws IOException {
        String path = "src/Data/toys";

        try {
            File file = new File(path);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {


        BaseToy toy1 = new BaseToy("Lyon");
        toy1.setId(1);
        toy1.setCount(5);
        toy1.setRarity(3);

        BaseToy toy2 = new BaseToy("Tiger");
        toy2.setId(2);
        toy2.setCount(14);
        toy2.setRarity(2);


        BaseToy[] toy_list = {toy1, toy2};

        DataIn.writeToys(toy_list);
    }

}
