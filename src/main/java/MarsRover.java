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
        System.out.println("Insert initial rover direction:");
        String input = reader.next(); //n = north, e = east, w = west, s = south
        Direction direction = Direction.fromString(input);
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            RoverState state = processCommand(roverx, rovery, direction, command);
            roverx = state.x();
            rovery = state.y();
            direction = state.direction();
            System.out.printf("Rover is at x:%d y:%d facing:%s%n", roverx, rovery, direction.toString());
        } while (true);
    }

    static RoverState processCommand(int roverx, int rovery, Direction direction, String command) {
        if (command.equals("f")) {
            roverx += direction.deltaX();
            rovery += direction.deltaY();
        }
        if (command.equals("b")) {
            roverx -= direction.deltaX();
            rovery -= direction.deltaY();
        }
        if (command.equals("l")) {
            direction = direction.rotateLeft();

        }
        if (command.equals("r")) {
            direction = direction.rotateRight();

        }

        return new RoverState(roverx, rovery, direction);
    }
}
