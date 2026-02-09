import java.util.ArrayList;
import java.util.List;

public class DogDoorSimulator {
    public static void main(String[] args) throws Exception {

        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        BarkRecognizer recognizer = new BarkRecognizer(door);

        // Store dogs and their sounds in ArrayList (support multiple dogs)
        List<Dog> dogs = new ArrayList<>();
        Dog fido = new Dog("Fido", new Bark("woof"));
        Dog bella = new Dog("Bella", new Bark("arf"));
        Dog max = new Dog("Max", new Bark("ruff"));

        dogs.add(fido);
        dogs.add(bella);
        dogs.add(max);

        // Register all dogs' barks as allowed barks on the door
        for (Dog dog : dogs) {
            door.addAllowedBark(dog.getBark());
        }

        // Example: Fido wants to go out – his bark is detected
        System.out.println(fido.getName() + " starts barking...");
        recognizer.recognize(fido.getBark());

        System.out.println(fido.getName() + " goes outside...");
        Thread.sleep(3000);

        System.out.println(fido.getName() + " comes back...");
        Thread.sleep(6000);

        // If the door is closed when the dog returns, simulate barking again
        if (!door.isOpen()) {
            System.out.println(fido.getName() + " barks again...");
            recognizer.recognize(fido.getBark());
        }

        // Remote functionality is still available (manual override)
        System.out.println("Owner presses the remote to close or open the door manually.");
        remote.pressButton();

        System.out.println(fido.getName() + " is inside.");
    }
}