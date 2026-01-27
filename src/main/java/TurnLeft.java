public class TurnLeft implements Command {

    @Override
    public RoverState execute(RoverState state, Planet planet) {
        Direction newDirection = state.direction().rotateLeft();
        return new RoverState(state.position(), newDirection);
    }
}
