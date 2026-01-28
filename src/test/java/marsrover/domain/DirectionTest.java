package marsrover.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({
            "NORTH, WEST",
            "WEST, SOUTH",
            "SOUTH, EAST",
            "EAST, NORTH"
    })
    void rotateLeft(Direction input, Direction expected) {
        assertThat(input.rotateLeft()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH, EAST",
            "EAST, SOUTH",
            "SOUTH, WEST",
            "WEST, NORTH"
    })
    void rotateRight(Direction input, Direction expected) {
        assertThat(input.rotateRight()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "n, NORTH",
            "N, NORTH",
            "e, EAST",
            "s, SOUTH",
            "w, WEST"
    })
    void fromString(String input, Direction expected) {
        assertThat(Direction.fromString(input)).isEqualTo(expected);
    }

    @Test
    void fromStringInvalidThrows() {
        assertThatThrownBy(() -> Direction.fromString("x"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}