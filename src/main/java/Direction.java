public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private static final Direction[] CACHED_VALUES = values();

    private final int deltaX;
    private final int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int deltaX() { return deltaX; }
    public int deltaY() { return deltaY; }

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