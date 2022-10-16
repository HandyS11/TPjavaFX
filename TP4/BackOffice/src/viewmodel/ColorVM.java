package viewmodel;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import model.MineColor;

public class ColorVM {

    private MineColor model;

    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();
        public javafx.scene.paint.Color getColor() { return color.get(); }
        public ObjectProperty<javafx.scene.paint.Color> colorProperty() { return color; }
        private void setColor(javafx.scene.paint.Color color) { this.color.set(color); }

    ColorVM(MineColor mineColor) {
        model = mineColor;
        colorProperty().set(new Color(((double) mineColor.getRed()) /255, ((double) mineColor.getGreen()) /255, ((double) mineColor.getBlue()) /255, 1));
        colorProperty().addListener((observable, oldValue, newValue) -> {
            mineColor.setRed((int) (newValue.getRed() * 255));
            mineColor.setGreen((int) (newValue.getGreen() * 255));
            mineColor.setBlue((int) (newValue.getBlue() * 255));
        });
    }

    public MineColor getModel() {
        return model;
    }
}
