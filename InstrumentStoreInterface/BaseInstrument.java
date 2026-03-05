public abstract class BaseInstrument implements Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;

    public BaseInstrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public InstrumentSpec getSpec() {
        return spec;
    }
}
