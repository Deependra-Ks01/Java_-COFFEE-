import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GuitarStoreInteractive {

    public static void main(String[] args) {
        Catalog inventory = new Catalog();
        
        // Optional: Load hardcoded defaults if you want, or start empty
        // initializeInventory(inventory); 

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Rick's Guitar Emporium Management System ---");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new Guitar (Manual)");
            System.out.println("2. Search for a Guitar");
            System.out.println("3. Import Inventory from File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewGuitar(inventory, scanner);
                    break;
                case "2":
                    searchGuitars(inventory, scanner);
                    break;
                case "3":
                    importInventoryFromFile(inventory, scanner);
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    // --- Feature: Import from File (New) ---
    private static void importInventoryFromFile(Catalog catalog, Scanner inputScanner) {
        System.out.print("Enter filename (e.g., guitars.txt): ");
        String filename = inputScanner.nextLine().trim();

        // Default to the file you uploaded if user hits enter
        if (filename.isEmpty()) {
            filename = "guitars.txt";
        }

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Error: File '" + filename + "' not found.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("Reading file...");

            // 1. Read the record count (The "20" at the top of your file)
            if (fileScanner.hasNextInt()) {
                int count = fileScanner.nextInt();
                fileScanner.nextLine(); // consume the newline after the number
                System.out.println("Header indicates " + count + " records found.");
            }

            int addedCount = 0;
            
            // 2. Loop through the file data
            while (fileScanner.hasNextLine()) {
                String serial = fileScanner.nextLine().trim();
                if (serial.isEmpty()) break; // Stop if we hit an empty line
                
                String manufacture = fileScanner.nextLine().trim();
                String model = fileScanner.nextLine().trim();
                String topWood = fileScanner.nextLine().trim();
                String backWood = fileScanner.nextLine().trim();
                
                double price = 0;
                if (fileScanner.hasNextDouble()) {
                    price = fileScanner.nextDouble();
                    if (fileScanner.hasNextLine()) fileScanner.nextLine(); // Consume newline
                }

                // Add to catalog
                catalog.addGuitar(serial, price, manufacture, model, topWood, backWood);
                addedCount++;
            }

            System.out.println("Success! Imported " + addedCount + " guitars.");

        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing file. Check the format.");
            e.printStackTrace();
        }
    }

    // --- Feature: Add Manual Guitar ---
    private static void addNewGuitar(Catalog catalog, Scanner scanner) {
        System.out.println("\n--- Add New Guitar ---");
        
        System.out.print("Enter Serial Number: ");
        String serial = scanner.nextLine().trim();

        double price = 0;
        while(true) {
            System.out.print("Enter Price: ");
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a number.");
            }
        }

        System.out.print("Enter Manufacturer: ");
        String manufacture = scanner.nextLine().trim();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Enter Top Wood: ");
        String topWood = scanner.nextLine().trim();
        System.out.print("Enter Back Wood: ");
        String backWood = scanner.nextLine().trim();

        catalog.addGuitar(serial, price, manufacture, model, topWood, backWood);
        System.out.println("Guitar added.");
    }

    // --- Feature: Search ---
    private static void searchGuitars(Catalog catalog, Scanner scanner) {
        System.out.println("\n--- Search Inventory ---");
        System.out.println("(Press Enter to skip filters)");

        System.out.print("Manufacture: ");
        String manufacture = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Top Wood: ");
        String topWood = scanner.nextLine().trim();
        System.out.print("Back Wood: ");
        String backWood = scanner.nextLine().trim();

        GuitarSpec clientSpec = new GuitarSpec(manufacture, model, topWood, backWood);
        List<Guitar> results = catalog.search(clientSpec);

        if (!results.isEmpty()) {
            System.out.println("\nFound " + results.size() + " matches:");
            for (Guitar g : results) {
                GuitarSpec spec = g.getSpec();
                System.out.println(" * " + spec.getManufacture() + " " + spec.getModel() + 
                                   " ($" + g.getPrice() + ")");
                System.out.println("   [Serial: " + g.getSerialNumber() + 
                                   " | Top: " + spec.getTopWood() + " / Back: " + spec.getBackWood() + "]");
            }
        } else {
            System.out.println("No matches found.");
        }
    }
}