import java.util.List;

public class PlayWithFactory {

    public static void main(String[] args) {
        Factory<Circle> factory = () -> new Circle();

        Circle circle = factory.newInstance();
        System.out.println("Circle = " + circle);

        List<Circle> list = factory.create5();
        System.out.println("List = " + list);
    }

}
