package marsrover.domain.command;

import marsrover.domain.Direction;
import marsrover.domain.Obstacles;
import marsrover.domain.Planet;
import marsrover.domain.RoverState;

public class TurnRight implements Command {

    @Override
    public CommandResult execute(RoverState state, Planet planet, Obstacles obstacles) {
        Direction newDirection = state.direction().rotateRight();
        return new CommandResult.Success(new RoverState(state.position(), newDirection));
    }
}
