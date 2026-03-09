import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Instrument> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        inventory.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstruments = new ArrayList<>();
        if (searchSpec == null) {
            matchingInstruments.addAll(inventory);
            return matchingInstruments;
        }

        for (Instrument instrument : inventory) {
            if (instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }
}
