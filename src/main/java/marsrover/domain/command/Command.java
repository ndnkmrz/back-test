package marsrover.domain.command;

import marsrover.domain.Obstacles;
import marsrover.domain.Planet;
import marsrover.domain.RoverState;

public interface Command {
    CommandResult execute(RoverState state, Planet planet, Obstacles obstacles);
}