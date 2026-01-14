public enum Type {
    ELECTRIC, ACOUSTIC, HYBRID;

    // Optional: Nice printing format
    public String toString() {
        switch(this) {
            case ELECTRIC: return "Electric";
            case ACOUSTIC: return "Acoustic";
            case HYBRID: return "Hybrid";
            default: return "Unspecified";
        }
    }
}