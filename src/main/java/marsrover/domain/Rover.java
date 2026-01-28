package marsrover.domain;

import marsrover.domain.command.Command;
import marsrover.domain.command.CommandParser;
import marsrover.domain.command.CommandResult;

public class Rover {

    private RoverState state;
    private final CommandParser parser = new CommandParser();

    public Rover(Position position, Direction direction) {
        this.state = new RoverState(position, direction);
    }

    public CommandResult execute(String commandString, Planet planet, Obstacles obstacles) {
        Command command = parser.parse(commandString);
        CommandResult result = command.execute(state, planet, obstacles);

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
