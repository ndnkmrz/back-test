public class MoveBackward implements Command {

    @Override
    public RoverState execute(RoverState state, Planet planet) {
        Position newPosition = state.position().moveBackward(state.direction());
        newPosition = planet.wrap(newPosition);
        return new RoverState(newPosition, state.direction());
    }
}
