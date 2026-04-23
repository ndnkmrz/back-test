package marsrover.domain.command;

import marsrover.domain.RoverState;

public interface Command {
    CommandResult execute(RoverState state, CommandContext context);
}