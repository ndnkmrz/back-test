package marsrover.domain.command;

public class CommandParser {

    private static final Command MOVE_FORWARD = new MoveForward();
    private static final Command MOVE_BACKWARD = new MoveBackward();
    private static final Command TURN_LEFT = new TurnLeft();
    private static final Command TURN_RIGHT = new TurnRight();

    public Command parse(String input) {
        return switch (input.toLowerCase()) {
            case "f" -> MOVE_FORWARD;
            case "b" -> MOVE_BACKWARD;
            case "l" -> TURN_LEFT;
            case "r" -> TURN_RIGHT;
            default -> throw new IllegalArgumentException("Unknown command: " + input);
        };
    }
}
