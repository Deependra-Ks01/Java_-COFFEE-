public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
    COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA, ANY;

    @Override
    public String toString() {
        return name().toLowerCase().replace('_', ' ');
    }
}
