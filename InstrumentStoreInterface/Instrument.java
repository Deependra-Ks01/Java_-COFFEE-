public interface Instrument {
    String getSerialNumber();

    double getPrice();

    void setPrice(double price);

    InstrumentSpec getSpec();
}
