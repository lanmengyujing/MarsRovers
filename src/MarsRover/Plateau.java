package MarsRover;

public class Plateau {
    private int upperX;
    private int upperY;
    static Plateau plateau;

    private Plateau() {
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau();
        }
        return plateau;
    }

    public void setUpperX(int upperX) {
        this.upperX = upperX;
    }

    public void setUpperY(int upperY) {
        this.upperY = upperY;
    }

    public boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= upperX && y <= upperY;
    }
}
