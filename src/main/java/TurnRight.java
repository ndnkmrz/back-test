public class TurnRight implements Command {

    @Override
    public CommandResult execute(RoverState state, Planet planet, Obstacles obstacles) {
        Direction newDirection = state.direction().rotateRight();
        return new CommandResult.Success(new RoverState(state.position(), newDirection));
    }
}
