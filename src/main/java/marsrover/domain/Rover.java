package marsrover.domain;

import marsrover.domain.command.Command;
import marsrover.domain.command.CommandContext;
import marsrover.domain.command.CommandResult;

public class Rover {

    private RoverState state;

    Rover(Position position, Direction direction) {
        this.state = new RoverState(position, direction);
    }

    public CommandResult execute(Command command, Planet planet, Obstacles obstacles) {
        CommandContext context = new CommandContext(planet, obstacles);
        CommandResult result = command.execute(state, context);

        if (result instanceof CommandResult.Success success) {
            state = success.state();
        }

        return result;
    }

    public Position position() {
        return state.position();
    }

    public Direction direction() {
        return state.direction();
    }
}
