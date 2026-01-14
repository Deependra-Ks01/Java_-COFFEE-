import java.util.List;
import java.util.Scanner;

public class GuitarStoreInteractive {

    public static void main(String[] args) {
        // 1. Initialize and Stock the Catalog
        Catalog inventory = new Catalog();
        initializeInventory(inventory);

        // 2. Prepare to read user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Rick's Guitar Emporium!");
        System.out.println("----------------------------------");
        System.out.println("Please describe the guitar you are looking for.");
        System.out.println("(Press Enter to skip a specific requirement)");

        // 3. Collect User Preferences
        System.out.print("Brand (e.g. Fender, Gibson): ");
        String brand = scanner.nextLine().trim();

        System.out.print("Model/Style (e.g. Stratocaster, Les Paul): ");
        String style = scanner.nextLine().trim();

        System.out.print("Type (Electric, Acoustic, or Hybrid): ");
        String typeString = scanner.nextLine().trim();
        Type type = null;
        // Convert string input to Enum safely
        if (!typeString.isEmpty()) {
            try {
                type = Type.valueOf(typeString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Warning: Invalid type entered. Ignoring type filter.");
            }
        }

        System.out.print("Back Wood (e.g. Maple, Mahogany): ");
        String backWood = scanner.nextLine().trim();

        System.out.print("Front Wood (e.g. Maple, Alder): ");
        String frontWood = scanner.nextLine().trim();

        // 4. Create the "Customer Request" object
        // We pass 0 for price and empty strings for unused fields, as the search logic handles them.
        Guitar clientSpecs = new Guitar("", 0, brand, style, type, "", backWood, frontWood);

        // 5. Run Search
        List<Guitar> results = inventory.search(clientSpecs);

        // 6. Display Results
        System.out.println("\nSearching our inventory...");
        if (!results.isEmpty()) {
            System.out.println("Good news! We found " + results.size() + " guitar(s) for you:");
            for (Guitar g : results) {
                System.out.println(" - " + g.getBrand() + " " + g.getStyle() + 
                                   " (" + g.getType() + ") Price: $" + g.getPrice());
                System.out.println("   Specs: " + g.getBackWood() + " back, " + g.getFrontWood() + " front.");
            }
        } else {
            System.out.println("Sorry, we have nothing in stock that matches those exact specs.");
        }
        
        scanner.close();
    }

    // Helper method to populate the store with dummy data
    private static void initializeInventory(Catalog catalog) {
        catalog.addGuitar("V95693", 1499.95, "Fender", "Stratocaster", Type.ELECTRIC, "Sunburst", "Alder", "Alder");
        catalog.addGuitar("V95123", 1549.95, "Fender", "Stratocaster", Type.ELECTRIC, "Red", "Alder", "Alder");
        catalog.addGuitar("A21455", 899.95, "Martin", "D-18", Type.ACOUSTIC, "Natural", "Mahogany", "Adirondack");
        catalog.addGuitar("G55621", 2099.95, "Gibson", "Les Paul", Type.ELECTRIC, "Gold", "Mahogany", "Maple");
        catalog.addGuitar("T12345", 499.95, "Taylor", "114ce", Type.ACOUSTIC, "Natural", "Walnut", "Sitka Spruce");
    }
}