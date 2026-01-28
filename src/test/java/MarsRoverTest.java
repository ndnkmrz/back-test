import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    private final Planet planet = new Planet(10, 10);

    @ParameterizedTest
    @CsvSource({
            // startX, startY, direction, command, expectedX, expectedY, expectedDir
            "0, 0, NORTH, f, 0, 1, NORTH",
            "0, 0, EAST, f, 1, 0, EAST",
            "0, 0, SOUTH, f, 0, 9, SOUTH",
            "0, 0, WEST, f, 9, 0, WEST",

            "0, 0, NORTH, b, 0, 9, NORTH",
            "0, 0, EAST, b, 9, 0, EAST",
            "0, 0, SOUTH, b, 0, 1, SOUTH",
            "0, 0, WEST, b, 1, 0, WEST",

            "0, 0, NORTH, l, 0, 0, WEST",
            "0, 0, WEST, l, 0, 0, SOUTH",
            "0, 0, SOUTH, l, 0, 0, EAST",
            "0, 0, EAST, l, 0, 0, NORTH",

            "0, 0, NORTH, r, 0, 0, EAST",
            "0, 0, EAST, r, 0, 0, SOUTH",
            "0, 0, SOUTH, r, 0, 0, WEST",
            "0, 0, WEST, r, 0, 0, NORTH"
    })
    void processCommand(int startX, int startY, Direction dir, String cmd,
                        int expectedX, int expectedY, Direction expectedDir) {
        Rover rover = new Rover(new Position(startX, startY), dir);
        Obstacles obstacles = Obstacles.empty();
        rover.execute(cmd, planet, obstacles);
        assertThat(rover.position().x()).isEqualTo(expectedX);
        assertThat(rover.position().y()).isEqualTo(expectedY);
        assertThat(rover.direction()).isEqualTo(expectedDir);
    }

    @Test
    void stopsAtObstacle() {
        Obstacles obstacles = new Obstacles(Set.of(new Position(0, 1)));
        Rover rover = new Rover(new Position(0, 0), Direction.NORTH);

        rover.execute("f", planet, obstacles);

        assertThat(rover.position()).isEqualTo(new Position(0, 0));
    }

    @Test
    void stopsAtObstacleWhenMovingBackward() {
        Obstacles obstacles = new Obstacles(Set.of(new Position(0, 9)));
        Rover rover = new Rover(new Position(0, 0), Direction.NORTH);

        rover.execute("b", planet, obstacles);

        assertThat(rover.position()).isEqualTo(new Position(0, 0));
    }

    @Test
    void rotatesEvenWithObstacleOnCurrentPosition() {
        Obstacles obstacles = new Obstacles(Set.of(new Position(0, 0)));
        Rover rover = new Rover(new Position(0, 0), Direction.NORTH);

        rover.execute("l", planet, obstacles);

        assertThat(rover.direction()).isEqualTo(Direction.WEST);
    }

    @Test
    void stopsAtObstacleAfterWrapping() {
        Obstacles obstacles = new Obstacles(Set.of(new Position(0, 0)));
        Rover rover = new Rover(new Position(0, 9), Direction.NORTH);

        rover.execute("f", planet, obstacles);

        assertThat(rover.position()).isEqualTo(new Position(0, 9));
    }
}