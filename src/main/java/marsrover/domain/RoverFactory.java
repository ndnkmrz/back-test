package marsrover.domain;

public class RoverFactory {
    public Rover spawn(Planet planet, Position position, Direction direction) {
        Position wrappedPosition = planet.wrap(position);
        return new Rover(wrappedPosition, direction);
    }
}
