package marsrover.domain;

public record Planet(int width, int height) {

    public Planet {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Planet dimensions must be positive");
        }
    }

    public Position wrap(Position position){
        int wrappedX = ((position.x() % width) + width) % width;
        int wrappedY = ((position.y() % height) + height) % height;
        return new Position(wrappedX, wrappedY);
    }
}
