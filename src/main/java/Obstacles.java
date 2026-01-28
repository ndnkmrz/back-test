import java.util.Set;

public class Obstacles {

    private final Set<Position> positions;

    public Obstacles(Set<Position> positions) {
        this.positions = positions;
    }

    public boolean hasObstacleAt(Position position) {
        return positions.contains(position);
    }

    public static Obstacles empty() {
        return new Obstacles(Set.of());
    }

}
