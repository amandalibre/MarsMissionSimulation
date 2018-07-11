public class Rocket implements SpaceShip {
    int cost;
    int maxWeight;
    int weight;
    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }
    public boolean canCarry(Item item) {
        return (item.weight  + weight < maxWeight);
    }
    public int carry(Item item) {
        weight += item.weight;
        return weight;
    }
}
