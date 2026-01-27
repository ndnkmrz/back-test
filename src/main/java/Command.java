public interface Command {
    RoverState execute(RoverState state, Planet planet);
}