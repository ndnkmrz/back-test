package marsrover.domain.command;

import marsrover.domain.Position;
import marsrover.domain.RoverState;

public class MoveBackward implements Command {

    @Override
    public CommandResult execute(RoverState state, CommandContext context) {
        Position newPosition = state.position().move(state.direction().opposite());
        newPosition = context.planet().wrap(newPosition);

        if (context.obstacles().hasObstacleAt(newPosition)) {
            return new CommandResult.ObstacleDetected(newPosition);
        }

        return new CommandResult.Success(new RoverState(newPosition, state.direction()));
    }
}
