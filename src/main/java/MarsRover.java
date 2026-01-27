import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();

        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();
        Position position = new Position(roverx, rovery);
        System.out.println("Insert initial rover direction:");
        String input = reader.next(); //n = north, e = east, w = west, s = south
        Direction direction = Direction.fromString(input);
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            RoverState state = processCommand(position, direction, command);
            position = state.position();
            direction = state.direction();
            System.out.printf("Rover is at x:%d y:%d facing:%s%n", position.x(), position.y(), direction.toString());
        } while (true);
    }

    static RoverState processCommand(Position position, Direction direction, String command) {
        if (command.equals("f")) {
            position = position.move(direction);
        }
        if (command.equals("b")) {
            position = position.moveBackward(direction);
        }
        if (command.equals("l")) {
            direction = direction.rotateLeft();

        }
        if (command.equals("r")) {
            direction = direction.rotateRight();

        }

        return new RoverState(position, direction);
    }
}
