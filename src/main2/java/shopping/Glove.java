package shopping;

public class Glove implements Colored, Sized {
  private String color;
  private int size;

  public Glove(String color, int size) {
    this.color = color;
    this.size = size;
  }

  @Override
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Glove{" +
        "color='" + color + '\'' +
        ", size=" + size +
        '}';
  }
}
