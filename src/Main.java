public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();


        toyStore.addToy(1, "Toy car", 10, 20);
        toyStore.addToy(2, "Doll", 5, 30);
        toyStore.addToy(3, "Robot", 8, 15);

        toyStore.updateToyWeight(1, 10.0);

        Toy prizeToy = toyStore.rafflePrizes();
        if (prizeToy != null) {
            System.out.println("Congratulations! Yoru prize is: " + prizeToy.getName());
            toyStore.decreaseToyQuantity(prizeToy);
            toyStore.writeToFile(prizeToy, "prize.txt");
        } else {
            System.out.println("Sorry! Out of toys...");
        }
    }
}
