package model;

import java.io.Serializable;

public class MineColor implements Serializable {

    private int red;
    private int green;
    private int blue;

    public MineColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MineColor mineColor = (MineColor) o;
        return red == mineColor.red && green == mineColor.green && blue == mineColor.blue;
    }
}
