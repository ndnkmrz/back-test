package marsrover.domain.command;

import marsrover.domain.Position;
import marsrover.domain.RoverState;

public sealed interface CommandResult {
    record Success(RoverState state) implements CommandResult {}
    record ObstacleDetected(Position obstacle) implements  CommandResult {}
}
