public class Rover {

    private RoverState state;
    private final CommandParser parser = new CommandParser();

    public Rover(Position position, Direction direction) {
        this.state = new RoverState(position, direction);
    }

    public void execute(String commandString, Planet planet) {
        Command command = parser.parse(commandString);
        state = command.execute(state, planet);
    }

    public Position position() {
        return state.position();
    }

    public Direction direction() {
        return state.direction();
    }
}
