package shopping2;

public class ClothingPair<E extends ClothingItem & Sized & Colored> extends Pair<E> {
    public ClothingPair(E left, E right) {
        super(left, right);
    }

    public boolean isMatched() {
        return left.getSize() == right.getSize() &&
                left.getColor().equals(right.getColor());
    }

    public static <X extends Sized & Colored> boolean match(X left, X right) {
        return left.getSize() == right.getSize() &&
                left.getColor().equals(right.getColor());
    }
}
