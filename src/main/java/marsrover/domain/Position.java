package marsrover.domain;

public record Position(int x, int y) {

    public Position move(Direction direction){
        return new Position(x + direction.deltaX(), y + direction.deltaY());
    }
}
