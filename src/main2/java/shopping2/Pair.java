package shopping2;

public class Pair<E> {
    protected E left;
    protected E right;

    public Pair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public E getRight() {
        return right;
    }

    public void setRight(E right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Pair{" +
            "left=" + left +
            ", right=" + right +
            '}';
    }

}
