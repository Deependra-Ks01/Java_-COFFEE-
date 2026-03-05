import java.io.File;
import java.util.List;
import java.util.Scanner;

public class InstrumentStoreInteractive {

    public static void main(String[] args) {
        Catalog inventory = new Catalog();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Rick's Instrument Store Management System ---");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new Guitar");
            System.out.println("2. Add a new Mandolin");
            System.out.println("3. Search for an Instrument");
            System.out.println("4. Import Inventory from File");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewGuitar(inventory, scanner);
                    break;
                case "2":
                    addNewMandolin(inventory, scanner);
                    break;
                case "3":
                    searchInstruments(inventory, scanner);
                    break;
                case "4":
                    importInventoryFromFile(inventory, scanner);
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    private static void importInventoryFromFile(Catalog catalog, Scanner inputScanner) {
        System.out.print("Enter filename (e.g., guitars.txt or mandolin.txt): ");
        String filename = inputScanner.nextLine().trim();

        if (filename.isEmpty())
            filename = "guitars.txt";

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Error: File '" + filename + "' not found.");
            return;
        }

        boolean isMandolinFile = filename.toLowerCase().contains("mandolin");

        try (Scanner fileScanner = new Scanner(file)) {
            if (fileScanner.hasNextInt()) {
                fileScanner.nextInt();
                fileScanner.nextLine();
            }

            int addedCount = 0;
            while (fileScanner.hasNextLine()) {
                String serial = fileScanner.nextLine().trim();
                if (serial.isEmpty())
                    break;

                String manufacture = fileScanner.nextLine().trim();
                String model = fileScanner.nextLine().trim();
                String topWood = fileScanner.nextLine().trim();
                String backWood = fileScanner.nextLine().trim();

                double price = 0;
                if (fileScanner.hasNextDouble()) {
                    price = fileScanner.nextDouble();
                    if (fileScanner.hasNextLine())
                        fileScanner.nextLine();
                }

                if (isMandolinFile) {
                    Style style = Style.A; // Default
                    if (fileScanner.hasNextLine()) {
                        try {
                            style = Style.valueOf(fileScanner.nextLine().trim().toUpperCase());
                        } catch (Exception e) {
                        }
                    }
                    catalog.addMandolin(serial, price, manufacture, model, topWood, backWood, style);
                } else {
                    catalog.addGuitar(serial, price, manufacture, model, topWood, backWood);
                }
                addedCount++;
            }
            System.out.println("Success! Imported " + addedCount + " instruments.");
        } catch (Exception e) {
            System.out.println("Error parsing file.");
            e.printStackTrace();
        }
    }

    private static void addNewGuitar(Catalog catalog, Scanner scanner) {
        System.out.println("\n--- Add New Guitar ---");
        System.out.print("Enter Serial Number: ");
        String serial = scanner.nextLine().trim();
        double price = readPrice(scanner);

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

    private static void addNewMandolin(Catalog catalog, Scanner scanner) {
        System.out.println("\n--- Add New Mandolin ---");
        System.out.print("Enter Serial Number: ");
        String serial = scanner.nextLine().trim();
        double price = readPrice(scanner);

        System.out.print("Enter Manufacturer: ");
        String manufacture = scanner.nextLine().trim();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Enter Top Wood: ");
        String topWood = scanner.nextLine().trim();
        System.out.print("Enter Back Wood: ");
        String backWood = scanner.nextLine().trim();

        Style style = readStyle(scanner);

        catalog.addMandolin(serial, price, manufacture, model, topWood, backWood, style);
        System.out.println("Mandolin added.");
    }

    private static double readPrice(Scanner scanner) {
        while (true) {
            System.out.print("Enter Price: ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price.");
            }
        }
    }

    private static Style readStyle(Scanner scanner) {
        while (true) {
            System.out.print("Enter Style (A/F): ");
            try {
                return Style.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid style.");
            }
        }
    }

    private static void searchInstruments(Catalog catalog, Scanner scanner) {
        System.out.println("\n--- Search Instruments ---");
        System.out.print("Type (G for Guitar, M for Mandolin, or Enter for Any): ");
        String typeChoice = scanner.nextLine().trim().toUpperCase();

        System.out.print("Manufacture: ");
        String manufacture = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Top Wood: ");
        String topWood = scanner.nextLine().trim();
        System.out.print("Back Wood: ");
        String backWood = scanner.nextLine().trim();

        InstrumentSpec clientSpec;
        if (typeChoice.equals("M")) {
            System.out.print("Style (A/F, or press Enter to skip): ");
            String styleStr = scanner.nextLine().trim().toUpperCase();
            Style style = null;
            if (!styleStr.isEmpty()) {
                try {
                    style = Style.valueOf(styleStr);
                } catch (Exception e) {
                }
            }
            clientSpec = new MandolinSpec(manufacture, model, topWood, backWood, style);
        } else if (typeChoice.equals("G")) {
            clientSpec = new GuitarSpec(manufacture, model, topWood, backWood);
        } else {
            clientSpec = new SimpleInstrumentSpec(manufacture, model, topWood, backWood);
        }

        List<Instrument> results = catalog.search(clientSpec);

        if (!results.isEmpty()) {
            System.out.println("\nFound " + results.size() + " matches:");
            for (Instrument i : results) {
                InstrumentSpec spec = i.getSpec();
                String typeName = (i instanceof Guitar) ? "Guitar" : "Mandolin";
                System.out.println(" * " + typeName + ": " + spec.getManufacture() + " " + spec.getModel() +
                        " ($" + i.getPrice() + ")");
                System.out.print("   [Serial: " + i.getSerialNumber() +
                        " | Top: " + spec.getTopWood() + " / Back: " + spec.getBackWood());
                if (spec instanceof MandolinSpec) {
                    System.out.print(" | Style: " + ((MandolinSpec) spec).getStyle());
                }
                System.out.println("]");
            }
        } else {
            System.out.println("No matches found.");
        }
    }
}