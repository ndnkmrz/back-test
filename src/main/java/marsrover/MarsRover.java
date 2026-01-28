package marsrover;

import marsrover.infrastructure.ConsoleAdapter;

import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {
        new ConsoleAdapter(new Scanner(System.in), System.out).run();
    }
}
