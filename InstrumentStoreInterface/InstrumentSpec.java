public interface InstrumentSpec {
    boolean matches(InstrumentSpec searchSpec);

    String getManufacture();

    String getModel();

    String getTopWood();

    String getBackWood();
}
