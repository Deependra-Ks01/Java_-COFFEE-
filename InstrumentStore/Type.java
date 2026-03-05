public enum Type {
    ELECTRIC, ACOUSTIC, HYBRID;

    public String toString() {
        switch(this) {
            case ELECTRIC: return "Electric";
            case ACOUSTIC: return "Acoustic";
            case HYBRID: return "Hybrid";
            default: return "Unspecified";
        }
    }
}