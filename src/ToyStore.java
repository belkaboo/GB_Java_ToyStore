import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ToyStore {

    private List<Toy> toys = new ArrayList<>();

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }


    public void updateToyWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("ID not found.");
    }


    public Toy rafflePrizes() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        Random random = new Random();
        double randomValue = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null;
    }

    public void writeToFile(Toy prizeToy, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Your prize is: " + prizeToy.getName());
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public void decreaseToyQuantity(Toy prizeToy) {
        prizeToy.setQuantity(prizeToy.getQuantity() - 1);
    }
}
