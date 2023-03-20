package Data;

import Toys.BaseToy;
import Winners.Winner;

import java.io.IOException;
import java.util.ArrayList;

public class Data {
    protected String toysPath;
    protected String winnersPath;

    public Data() {
        this.toysPath = "src/database/toys";
        this.winnersPath = "src/database/winners";
    }

    public void writeToys(ArrayList<BaseToy> toyList) throws IOException {
    }

    public void writeWinners(ArrayList<Winner> winnerList) throws IOException {
    }

    public ArrayList<BaseToy> readToys() throws IOException {
        return null;
    }

    public ArrayList<Winner> readWinners() throws IOException {
        return null;
    }
}
