public record Planet(int width, int height) {

    public Position wrap(Position position){
        return position;
    }
}
