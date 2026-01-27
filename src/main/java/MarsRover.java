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
        String roverz = reader.next(); //n = north, e = east, w = west, s = south
        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            RoverState state = processCommand(roverx, rovery, roverz, command);
            roverx = state.x();
            rovery = state.y();
            roverz = state.direction();
            System.out.printf("Rover is at x:%d y:%d facing:%s%n", roverx, rovery, roverz);
        } while (true);
    }

    static RoverState processCommand(int roverx, int rovery, String roverz, String command) {
        if (command.equals("f")) {
            if (roverz.equals("n")) {
                rovery += 1;
            }
            if (roverz.equals("w")) {
                roverx -= 1;
            }
            if (roverz.equals("s")) {
                rovery -= 1;
            }
            if (roverz.equals("e")) {
                roverx += 1;
            }
        }
        if (command.equals("b")) {
            if (roverz.equals("n")) {
                rovery -= 1;
            }
            if (roverz.equals("w")) {
                roverx += 1;
            }
            if (roverz.equals("s")) {
                rovery += 1;
            }
            if (roverz.equals("e")) {
                roverx -= 1;
            }
        }
        if (command.equals("l")) {
            if (roverz.equals("n")) {
                roverz = "w";
            }
            else if (roverz.equals("w")) {
                roverz = "s";
            }
            else if (roverz.equals("s")) {
                roverz = "e";
            }
            else if (roverz.equals("e")) {
                roverz = "n";
            }
        }
        if (command.equals("r")) {
            if (roverz.equals("n")) {
                roverz = "e";
            }
            else if (roverz.equals("e")) {
                roverz = "s";
            }
            else if (roverz.equals("s")) {
                roverz = "w";
            }
            else if (roverz.equals("w")) {
                roverz = "n";
            }
        }

        return new RoverState(roverx, rovery, roverz);
    }
}
