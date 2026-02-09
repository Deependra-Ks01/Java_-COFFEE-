public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Bark)) return false;
        Bark other = (Bark) obj;
        // Compare sounds ignoring case so small variations in case don't matter
        return sound != null && sound.equalsIgnoreCase(other.sound);
    }

    @Override
    public int hashCode() {
        return sound == null ? 0 : sound.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Bark{" +
                "sound='" + sound + '\'' +
                '}';
    }
}

