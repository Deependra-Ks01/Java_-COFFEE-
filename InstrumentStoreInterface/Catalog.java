import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Guitar> guitars;
    private List<Mandolin> mandolins;

    public Catalog() {
        this.guitars = new ArrayList<>();
        this.mandolins = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String manufacture, String model,
            String topWood, String backWood) {
        GuitarSpec spec = new GuitarSpec(manufacture, model, topWood, backWood);
        guitars.add(new Guitar(serialNumber, price, spec));
    }

    public void addMandolin(String serialNumber, double price, String manufacture, String model,
            String topWood, String backWood, Style style) {
        MandolinSpec spec = new MandolinSpec(manufacture, model, topWood, backWood, style);
        mandolins.add(new Mandolin(serialNumber, price, spec));
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstruments = new ArrayList<>();

        // Search guitars
        for (Guitar guitar : guitars) {
            if (guitar.getSpec().matches(searchSpec)) {
                matchingInstruments.add(guitar);
            }
        }

        // Search mandolins
        for (Mandolin mandolin : mandolins) {
            if (mandolin.getSpec().matches(searchSpec)) {
                matchingInstruments.add(mandolin);
            }
        }

        return matchingInstruments;
    }
}