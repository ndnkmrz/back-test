package marsrover.infrastructure;

import marsrover.domain.*;
import marsrover.domain.command.Command;
import marsrover.domain.command.CommandParser;
import marsrover.domain.command.CommandResult;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleAdapter {

    private final Scanner scanner;
    private final PrintStream output;
    private final RoverFactory roverFactory;
    private final CommandParser commandParser;

    public ConsoleAdapter(Scanner scanner, PrintStream output, RoverFactory roverFactory, CommandParser commandParser) {
        this.scanner = scanner;
        this.output = output;
        this.roverFactory = roverFactory;
        this.commandParser = commandParser;
    }

    public void run() {
        Planet planet = readPlanet();
        Position position = readPosition();
        Direction direction = readDirection();
        Obstacles obstacles = readObstacles();

        Rover rover = roverFactory.spawn(planet, position, direction);

        while (true) {
            output.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String input = scanner.next();
            Command cmd = commandParser.parse(input);
            CommandResult result = rover.execute(cmd, planet, obstacles);

            switch (result) {
                case CommandResult.Success s -> output.printf(
                        "Rover is at x:%d y:%d facing:%s%n",
                        rover.position().x(),
                        rover.position().y(),
                        rover.direction()
                );
                case CommandResult.ObstacleDetected o -> output.printf(
                        "Obstacle detected at x:%d y:%d! Rover stayed at x:%d y:%d facing:%s%n",
                        o.obstacle().x(),
                        o.obstacle().y(),
                        rover.position().x(),
                        rover.position().y(),
                        rover.direction()
                );
            }
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
