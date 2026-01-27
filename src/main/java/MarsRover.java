import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();
        Planet planet = new Planet(sizex, sizey);
        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();
        Position position = new Position(roverx, rovery);
        System.out.println("Insert initial rover direction:");
        String input = reader.next(); //n = north, e = east, w = west, s = south
        Direction direction = Direction.fromString(input);
        Rover rover = new Rover(position, direction);
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            rover.execute(command, planet);
            System.out.printf("Rover is at x:%d y:%d facing:%s%n",
                    rover.position().x(),
                    rover.position().y(),
                    rover.direction());
        } while (true);
    }
}
