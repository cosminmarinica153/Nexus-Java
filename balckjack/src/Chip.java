public class Chip {
    private final String color;
    private final int value;

    public Chip(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "color='" + color + '\'' +
                ", value=" + value +
                '}';
    }
}
