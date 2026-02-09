public class Dog {

    private String name;
    private Bark bark;

    public Dog(String name, Bark bark) {
        this.name = name;
        this.bark = bark;
    }

    public String getName() {
        return name;
    }

    public Bark getBark() {
        return bark;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', bark=" + bark + "}";
    }
}

