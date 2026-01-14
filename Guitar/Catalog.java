import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Guitar> guitars;

    public Catalog() {
        this.guitars = new ArrayList<>();
    }

    // Corresponds to "insertGuitar" on Board 1
    public void addGuitar(String serialNumber, double price, String brand, String style, 
                          Type type, String color, String backWood, String frontWood) {
        Guitar newGuitar = new Guitar(serialNumber, price, brand, style, type, color, backWood, frontWood);
        guitars.add(newGuitar);
    }

    // The Search method sketched on Board 2
    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> matchingGuitars = new ArrayList<>();

        for (Guitar guitar : guitars) {
            // Logic from Board 2: Compare each field.
            // If the searchGuitar has a value (is not null/empty) and it doesn't match, we skip it.
            
            // Check Brand
            if (searchGuitar.getBrand() != null && !searchGuitar.getBrand().equals("") &&
                !searchGuitar.getBrand().equalsIgnoreCase(guitar.getBrand()))
                continue;

            // Check Style (as seen on board: if(g.style != given.style) continue)
            if (searchGuitar.getStyle() != null && !searchGuitar.getStyle().equals("") &&
                !searchGuitar.getStyle().equalsIgnoreCase(guitar.getStyle()))
                continue;

            // Check Type (Enum comparison uses == or equals)
            if (searchGuitar.getType() != null && guitar.getType() != searchGuitar.getType())
                continue;

            // Check Back Wood
            if (searchGuitar.getBackWood() != null && !searchGuitar.getBackWood().equals("") &&
                !searchGuitar.getBackWood().equalsIgnoreCase(guitar.getBackWood()))
                continue;

            // Check Front Wood
            if (searchGuitar.getFrontWood() != null && !searchGuitar.getFrontWood().equals("") &&
                !searchGuitar.getFrontWood().equalsIgnoreCase(guitar.getFrontWood()))
                continue;

            // If we passed all checks, add to results
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}