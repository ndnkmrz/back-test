package marsrover.domain.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CommandParserTest {

    private final CommandParser parser = new CommandParser();

    @ParameterizedTest
    @ValueSource(strings = {"f", "F"})
    void parseForward(String input) {
        assertThat(parser.parse(input)).isInstanceOf(MoveForward.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"b", "B"})
    void parseBackward(String input) {
        assertThat(parser.parse(input)).isInstanceOf(MoveBackward.class);
    }

    @Test
    void parseInvalidThrows() {
        assertThatThrownBy(() -> parser.parse("x"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
