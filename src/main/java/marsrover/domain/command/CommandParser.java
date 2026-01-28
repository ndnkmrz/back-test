package marsrover.domain.command;

public class CommandParser {

    public Command parse(String input) {
        return switch (input.toLowerCase()) {
            case "f" -> new MoveForward();
            case "b" -> new MoveBackward();
            case "l" -> new TurnLeft();
            case "r" -> new TurnRight();
            default -> throw new IllegalArgumentException("Unknown command: " + input);
        };
    }
}
