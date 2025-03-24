package draft;

public class Main {
    public static void main(String[] args) {
        String[] circleArgs = {"CircleSketch", "100"};  // Circle with radius 100
        String[] squareArgs = {"SquareSketch", "150"};  // Square with side 150
        String[] triangleArgs = {"TriangleSketch", "120"};  // Triangle with side 120
        String[] pentagonArgs = {"PentagonSketch", "80"};  // Pentagon with side 80

        CircleSketch.main(circleArgs);
        SquareSketch.main(squareArgs);
        TriangleSketch.main(triangleArgs);
        PentagonSketch.main(pentagonArgs);
    }
}
