package marsrover.domain.command;

import marsrover.domain.Obstacles;
import marsrover.domain.Planet;
import marsrover.domain.Position;
import marsrover.domain.RoverState;

public class MoveBackward implements Command {

    @Override
    public CommandResult execute(RoverState state, Planet planet, Obstacles obstacles) {
        Position newPosition = state.position().move(state.direction().opposite());
        newPosition = planet.wrap(newPosition);

        if (obstacles.hasObstacleAt(newPosition)) {
            return new CommandResult.ObstacleDetected(newPosition);
        }

        return new CommandResult.Success(new RoverState(newPosition, state.direction()));
    }
}
