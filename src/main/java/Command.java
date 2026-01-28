public interface Command {
    CommandResult execute(RoverState state, Planet planet, Obstacles obstacles);
}