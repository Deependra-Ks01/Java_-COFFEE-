import java.util.ArrayList;
import java.util.List;

public class DogDoor {
    private boolean open;
    private List<Bark> allowedBarks;

    public DogDoor() {
        this.open = false;
        this.allowedBarks = new ArrayList<>();
    }

    // Allow configuring multiple dogs (multiple bark sounds)
    public void addAllowedBark(Bark bark) {
        allowedBarks.add(bark);
    }

    public List<Bark> getAllowedBarks() {
        return allowedBarks;
    }

    public boolean isAllowedBark(Bark bark) {
        for (Bark allowed : allowedBarks) {
            if (allowed.equals(bark)) {
                return true;
            }
        }
        return false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;

        // Auto-close after some time
        new Thread(() -> {
            try {
                Thread.sleep(5000); // 5 seconds
                close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}