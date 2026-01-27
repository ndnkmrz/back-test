public class TurnRight implements Command {
    @Override
    public RoverState execute(RoverState state, Planet planet) {
        Direction newDirection = state.direction().rotateRight();
        return new RoverState(state.position(), newDirection);
    }
}
