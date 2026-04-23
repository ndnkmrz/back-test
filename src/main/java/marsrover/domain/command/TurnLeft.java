package marsrover.domain.command;

import marsrover.domain.Direction;
import marsrover.domain.RoverState;

public class TurnLeft implements Command {

    @Override
    public CommandResult execute(RoverState state, CommandContext context) {
        Direction newDirection = state.direction().rotateLeft();
        return new CommandResult.Success(new RoverState(state.position(), newDirection));
    }
}
