public class TurnLeft implements Command {

    @Override
    public CommandResult execute(RoverState state, Planet planet, Obstacles obstacles) {
        Direction newDirection = state.direction().rotateLeft();
        return new CommandResult.Success(new RoverState(state.position(), newDirection));
    }
}
