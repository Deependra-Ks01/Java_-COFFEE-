import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Guitar> guitars;

    public Catalog() {
        this.guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String manufacture, String model, 
                          String topWood, String backWood) {
        // Create the Spec object first
        GuitarSpec spec = new GuitarSpec(manufacture, model, topWood, backWood);
        // Create the Guitar object using that Spec
        Guitar newGuitar = new Guitar(serialNumber, price, spec);
        guitars.add(newGuitar);
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new ArrayList<>();

        for (Guitar guitar : guitars) {
            // Delegate comparison to the Spec object
            if (guitar.getSpec().matches(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}