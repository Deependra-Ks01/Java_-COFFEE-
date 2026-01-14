public class GuitarSpec {
    private String manufacture; // Previously "brand"
    private String model;       // Previously "style"
    private String topWood;     // Previously "frontWood"
    private String backWood;

    public GuitarSpec(String manufacture, String model, String topWood, String backWood) {
        this.manufacture = manufacture;
        this.model = model;
        this.topWood = topWood;
        this.backWood = backWood;
    }

    // The comparison logic
    public boolean matches(GuitarSpec otherSpec) {
        // Check Manufacture
        if (otherSpec.getManufacture() != null && !otherSpec.getManufacture().equals("") &&
            !manufacture.equalsIgnoreCase(otherSpec.getManufacture()))
            return false;
        
        // Check Model
        if (otherSpec.getModel() != null && !otherSpec.getModel().equals("") &&
            !model.equalsIgnoreCase(otherSpec.getModel()))
            return false;
        
        // Check Top Wood
        if (otherSpec.getTopWood() != null && !otherSpec.getTopWood().equals("") &&
            !topWood.equalsIgnoreCase(otherSpec.getTopWood()))
            return false;
        
        // Check Back Wood
        if (otherSpec.getBackWood() != null && !otherSpec.getBackWood().equals("") &&
            !backWood.equalsIgnoreCase(otherSpec.getBackWood()))
            return false;

        return true;
    }

    // Getters
    public String getManufacture() { return manufacture; }
    public String getModel() { return model; }
    public String getTopWood() { return topWood; }
    public String getBackWood() { return backWood; }
}