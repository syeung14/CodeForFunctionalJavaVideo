public class Circle {
    private Color color;
    public Circle() {
        this(Color.WHITE);
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
       return color.toString();
    }
}
