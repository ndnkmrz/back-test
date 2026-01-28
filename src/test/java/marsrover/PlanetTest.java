package marsrover;

import marsrover.domain.Planet;
import marsrover.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
