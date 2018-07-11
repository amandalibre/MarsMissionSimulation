import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        ArrayList<Item> itemListPhase1 = simulation.loadItems(new File ("C:\\Users\\Amanda\\IdeaProjects\\MarsMissionSimulation\\src\\phase-1.txt"));
        ArrayList<Item> itemListPhase2 = simulation.loadItems(new File ("C:\\Users\\Amanda\\IdeaProjects\\MarsMissionSimulation\\src\\phase-2.txt"));
        ArrayList<Rocket> u1ListPhase1 = simulation.loadU1(itemListPhase1);
        ArrayList<Rocket> u1ListPhase2 = simulation.loadU1(itemListPhase2);
        int phase1CostU1 = simulation.runSimulation(u1ListPhase1);
        int phase2CostU1 = simulation.runSimulation(u1ListPhase2);
        int totalU1Budget = phase1CostU1 + phase2CostU1;
        System.out.println("total U1 budget: " + totalU1Budget);
        ArrayList<Rocket> u2ListPhase1 = simulation.loadU2(itemListPhase1);
        ArrayList<Rocket> u2ListPhase2 = simulation.loadU2(itemListPhase2);
        int phase1CostU2 = simulation.runSimulation(u2ListPhase1);
        int phase2CostU2 = simulation.runSimulation(u2ListPhase2);
        int totalU2Budget = phase1CostU2 + phase2CostU2;
        System.out.println("total U2 budget: " + totalU2Budget);
    }
}
