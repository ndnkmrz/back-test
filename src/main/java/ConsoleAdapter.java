import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleAdapter {

    private final Scanner scanner;
    private final PrintStream output;

    public ConsoleAdapter(Scanner scanner, PrintStream output) {
        this.scanner = scanner;
        this.output = output;
    }

    public void run() {
        Planet planet = readPlanet();
        Position position = readPosition();
        Direction direction = readDirection();
        Obstacles obstacles = readObstacles();

        Rover rover = new Rover(position, direction);

        while (true) {
            output.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = scanner.next();
            rover.execute(command, planet, obstacles);
            output.printf("Rover is at x:%d y:%d facing:%s%n",
                    rover.position().x(),
                    rover.position().y(),
                    rover.direction());
        }
    }

    private Planet readPlanet() {
        output.println("Insert horizontal map size:");
        int width = scanner.nextInt();
        output.println("Insert vertical map size:");
        int height = scanner.nextInt();
        return new Planet(width, height);
    }

    private Position readPosition() {
        output.println("Insert horizontal initial rover position:");
        int x = scanner.nextInt();
        output.println("Insert vertical initial rover position:");
        int y = scanner.nextInt();
        return new Position(x, y);
    }

    private Direction readDirection() {
        output.println("Insert initial rover direction:");
        String input = scanner.next();
        return Direction.fromString(input);
    }

    private Obstacles readObstacles() {
        output.println("Insert number of obstacles:");
        int count = scanner.nextInt();
        Set<Position> positions = new HashSet<>();
        for (int i = 0; i < count; i++) {
            output.printf("Insert obstacle %d x:%n", i + 1);
            int x = scanner.nextInt();
            output.printf("Insert obstacle %d y:%n", i + 1);
            int y = scanner.nextInt();
            positions.add(new Position(x, y));
        }
        return new Obstacles(positions);
    }

}
