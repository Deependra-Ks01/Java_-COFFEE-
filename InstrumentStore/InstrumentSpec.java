public class InstrumentSpec {
    private String manufacture;
    private String model;
    private String topWood;
    private String backWood;

    public InstrumentSpec(String manufacture, String model, String topWood, String backWood) {
        this.manufacture = manufacture;
        this.model = model;
        this.topWood = topWood;
        this.backWood = backWood;
    }

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

    public String getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public String getTopWood() {
        return topWood;
    }

    public String getBackWood() {
        return backWood;
    }
}
