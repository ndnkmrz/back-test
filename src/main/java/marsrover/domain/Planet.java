package marsrover.domain;

public record Planet(int width, int height) {

    public Position wrap(Position position){
        int wrappedX = ((position.x() % width) + width) % width;
        int wrappedY = ((position.y() % height) + height) % height;
        return new Position(wrappedX, wrappedY);
    }
}
