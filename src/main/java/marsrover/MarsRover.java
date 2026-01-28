package marsrover;

import marsrover.domain.RoverFactory;
import marsrover.infrastructure.ConsoleAdapter;

import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {
        new ConsoleAdapter(
                new Scanner(System.in),
                System.out,
                new RoverFactory()).run();
    }
}
