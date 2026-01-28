public class MoveForward implements Command {

    @Override
    public CommandResult execute(RoverState state, Planet planet, Obstacles obstacles) {
        Position newPosition = state.position().move(state.direction());
        newPosition = planet.wrap(newPosition);

        if (obstacles.hasObstacleAt(newPosition)) {
            return new CommandResult.ObstacleDetected(newPosition);
        }

        return new CommandResult.Success(new RoverState(newPosition, state.direction()));
    }
}
