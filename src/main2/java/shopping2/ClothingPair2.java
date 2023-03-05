package shopping2;

public class ClothingPair2<S extends Sized & Colored> extends Pair<S> {

    public ClothingPair2(S left, S right) {
        super(left, right);
    }

    public boolean matched() {
        return left.getSize() == right.getSize() &&
            left.getColor() == right.getColor();
    }
}
