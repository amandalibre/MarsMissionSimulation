import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    public ArrayList loadItems(File file) throws FileNotFoundException {
        ArrayList itemList = new ArrayList();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            Item item = new Item();
            String line = scanner.nextLine();
            String[] itemDetails = line.split("=");
            item.name = itemDetails[0];
            item.weight = Integer.parseInt(itemDetails[1]);
            itemList.add(item);
        }
        return itemList;
    }

    public ArrayList loadU1(ArrayList<Item> loadItems) {
        ArrayList u1List = new ArrayList();
        U1 u1 = new U1();
        for (Item item : loadItems) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1List.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
        }
        return u1List;
    }

    public ArrayList loadU2(ArrayList<Item> loadItems) {
        ArrayList u2List = new ArrayList();
        U2 u2 = new U2();
        for (Item item : loadItems) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2List.add(u2);
                u2 = new U2();
                u2.carry(item);
            }
        }
        return u2List;
    }

    public static int runSimulation(ArrayList<Rocket> rocketList) {
        int budget = 0;
        for (Rocket rocket : rocketList) {
            budget += rocket.cost;
            while (!rocket.launch() || !rocket.land()) {
                budget += rocket.cost;;
            }
        }
        return budget;
    }
}
