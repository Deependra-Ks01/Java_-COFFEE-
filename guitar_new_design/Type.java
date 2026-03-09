public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }
}
