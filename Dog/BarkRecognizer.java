public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "' bark.");

        if (door.isAllowedBark(bark)) {
            System.out.println("BarkRecognizer: This is an allowed dog. Opening the door...");
            door.open();
        } else {
            System.out.println("BarkRecognizer: This bark is not recognized. Door stays closed.");
        }
    }
}

