public class MoveForward implements Command {

    @Override
    public RoverState execute(RoverState state, Planet planet) {
        Position newPosition = state.position().move(state.direction());
        newPosition = planet.wrap(newPosition);
        return new RoverState(newPosition, state.direction());
    }
}
