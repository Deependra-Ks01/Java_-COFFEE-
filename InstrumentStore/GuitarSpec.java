public class GuitarSpec extends InstrumentSpec {
    public GuitarSpec(String manufacture, String model, String topWood, String backWood) {
        super(manufacture, model, topWood, backWood);
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (otherSpec instanceof MandolinSpec)
            return false;
        return true;
    }
}