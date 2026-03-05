public class MandolinSpec extends BaseInstrumentSpec {
    private Style style;

    public MandolinSpec(String manufacture, String model, String topWood, String backWood, Style style) {
        super(manufacture, model, topWood, backWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (!(otherSpec instanceof MandolinSpec))
            return false;
        MandolinSpec ms = (MandolinSpec) otherSpec;
        if (ms.getStyle() != null && style != ms.getStyle())
            return false;
        return true;
    }
}
