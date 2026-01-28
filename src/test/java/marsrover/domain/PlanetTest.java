package marsrover.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlanetTest {

    private final Planet planet = new Planet(10, 10);

    @Test
    void wrapRightEdge() {
        Position pos = new Position(10, 5);
        assertThat(planet.wrap(pos)).isEqualTo(new Position(0, 5));
    }

    @Test
    void wrapLeftEdge() {
        Position pos = new Position(-1, 5);
        assertThat(planet.wrap(pos)).isEqualTo(new Position(9, 5));
    }

    @Test
    void wrapDouble() {
        Position pos = new Position(-15, -23);
        assertThat(planet.wrap(pos)).isEqualTo(new Position(5, 7));
    }

    @Test
    void wrapTopEdge() {
        Planet planet = new Planet(10, 10);
        Position pos = new Position(5, 10);

        assertThat(planet.wrap(pos)).isEqualTo(new Position(5, 0));
    }

    @Test
    void wrapBottomEdge() {
        Planet planet = new Planet(10, 10);
        Position pos = new Position(5, -1);

        assertThat(planet.wrap(pos)).isEqualTo(new Position(5, 9));
    }

    @Test
    void invalidDimensionsThrow() {
        assertThatThrownBy(() -> new Planet(0, 10))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Planet(10, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
