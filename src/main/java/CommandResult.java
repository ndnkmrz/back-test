public sealed interface CommandResult {
    record Success(RoverState state) implements CommandResult {}
    record ObstacleDetected(Position obstacle) implements  CommandResult {}
}
