package marsrover.domain.command;

import marsrover.domain.Obstacles;
import marsrover.domain.Planet;

public record CommandContext(Planet planet, Obstacles obstacles) {
}
