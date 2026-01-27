import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    @ParameterizedTest
    @CsvSource({
            // startX, startY, direction, command, expectedX, expectedY, expectedDir
            "0, 0, n, f, 0, 1, n",
            "0, 0, e, f, 1, 0, e",
            "0, 0, s, f, 0, -1, s",
            "0, 0, w, f, -1, 0, w",

            "0, 0, n, b, 0, -1, n",
            "0, 0, e, b, -1, 0, e",
            "0, 0, s, b, 0, 1, s",
            "0, 0, w, b, 1, 0, w",

            "0, 0, n, l, 0, 0, w",
            "0, 0, w, l, 0, 0, s",
            "0, 0, s, l, 0, 0, e",
            "0, 0, e, l, 0, 0, n",

            "0, 0, n, r, 0, 0, e",
            "0, 0, e, r, 0, 0, s",
            "0, 0, s, r, 0, 0, w",
            "0, 0, w, r, 0, 0, n"
    })
    void processCommand(int startX, int startY, String dir, String cmd,
                        int expectedX, int expectedY, String expectedDir) {
        RoverState result = MarsRover.processCommand(startX, startY, dir, cmd);

        assertThat(result.x()).isEqualTo(expectedX);
        assertThat(result.y()).isEqualTo(expectedY);
        assertThat(result.direction()).isEqualTo(expectedDir);
    }
}