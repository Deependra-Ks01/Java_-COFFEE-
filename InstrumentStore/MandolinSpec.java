public class MandolinSpec extends InstrumentSpec {
    private Style style;

    public MandolinSpec(String manufacture, String model, String topWood, String backWood, Style style) {
        super(manufacture, model, topWood, backWood);
        this.style = style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (otherSpec instanceof GuitarSpec)
            return false;
        if (otherSpec instanceof MandolinSpec) {
            MandolinSpec spec = (MandolinSpec) otherSpec;
            if (spec.getStyle() != null && style != spec.getStyle())
                return false;
        }
        return true;
    }

    public Style getStyle() {
        return style;
    }
}
