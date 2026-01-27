public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static final Direction[] CACHED_VALUES = values();

    public Direction rotateLeft() {
        return CACHED_VALUES[(ordinal() + 3) % 4];
    }

    public Direction rotateRight() {
        return CACHED_VALUES[(ordinal() + 1) % 4];
    }

    public static Direction fromString(String input) {
        return switch (input.toLowerCase()) {
            case "n" -> NORTH;
            case "e" -> EAST;
            case "s" -> SOUTH;
            case "w" -> WEST;
            default -> throw new IllegalArgumentException("Unknown direction: " + input);
        };
    }
}