public class Program {
    public static void main(String[] args) {
        Point point = new Point(2, 2);
        System.out.println(point.toString());
    }

}

record Point (int x, int y) {
    @Override
    public final String toString() {
        return String.format("Point{x: %d, y: %d}", this.x, this.y);
    }
}
