import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        RoverState result = MarsRover.processCommand(new Position(startX, startY), dir, cmd, planet);

        assertThat(result.position().x()).isEqualTo(expectedX);
        assertThat(result.position().y()).isEqualTo(expectedY);
        assertThat(result.direction()).isEqualTo(expectedDir);
    }
}