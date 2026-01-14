public class Guitar {
    // Attributes from Board 1
    private String serialNumber; // Standard unique ID usually required
    private double price;
    private String brand;
    private String style; // e.g., "Stratocaster", "Dreadnought"
    private Type type;    // The Enum defined above
    private String color;
    private String backWood;
    private String frontWood;

    // Constructor
    public Guitar(String serialNumber, double price, String brand, String style, 
                  Type type, String color, String backWood, String frontWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.brand = brand;
        this.style = style;
        this.type = type;
        this.color = color;
        this.backWood = backWood;
        this.frontWood = frontWood;
    }

    // Getters (and Setters)
    public String getSerialNumber() { return serialNumber; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getBrand() { return brand; }
    public String getStyle() { return style; }
    public Type getType() { return type; }
    public String getColor() { return color; }
    public String getBackWood() { return backWood; }
    public String getFrontWood() { return frontWood; }

    @Override
    public String toString() {
        return "Guitar Specs: " + serialNumber + " " + brand + " " + style + " " + type + 
               " (" + price + ")";
    }
}