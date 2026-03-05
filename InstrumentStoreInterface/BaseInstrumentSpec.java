public abstract class BaseInstrumentSpec implements InstrumentSpec {
    private String manufacture;
    private String model;
    private String topWood;
    private String backWood;

    public BaseInstrumentSpec(String manufacture, String model, String topWood, String backWood) {
        this.manufacture = manufacture;
        this.model = model;
        this.topWood = topWood;
        this.backWood = backWood;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (otherSpec.getManufacture() != null && !otherSpec.getManufacture().equals("") &&
                !manufacture.equalsIgnoreCase(otherSpec.getManufacture()))
            return false;

        if (otherSpec.getModel() != null && !otherSpec.getModel().equals("") &&
                !model.equalsIgnoreCase(otherSpec.getModel()))
            return false;

        if (otherSpec.getTopWood() != null && !otherSpec.getTopWood().equals("") &&
                !topWood.equalsIgnoreCase(otherSpec.getTopWood()))
            return false;

        if (otherSpec.getBackWood() != null && !otherSpec.getBackWood().equals("") &&
                !backWood.equalsIgnoreCase(otherSpec.getBackWood()))
            return false;

        return true;
    }

    @Override
    public String getManufacture() {
        return manufacture;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getTopWood() {
        return topWood;
    }

    @Override
    public String getBackWood() {
        return backWood;
    }
}
