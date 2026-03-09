public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }
}
