package viewmodel;

import javafx.beans.property.*;
import model.Color;

public class ColorVM {

    private Color model;

    private final IntegerProperty red = new SimpleIntegerProperty();
        public int getRed() { return red.get(); }
        public ReadOnlyIntegerProperty redProperty() { return red; }
        private void setRed(int red) { this.red.set(red); }

    private final IntegerProperty green = new SimpleIntegerProperty();
        public int getGreen() { return green.get(); }
        public ReadOnlyIntegerProperty greenProperty()  {return green; }
        private void setGreen(int green) { this.green.set(green); }

    private final IntegerProperty blue = new SimpleIntegerProperty();
        public int getBlue() { return blue.get(); }
        public ReadOnlyIntegerProperty blueProperty() { return blue; }
        private void setBlue(int blue) { this.blue.set(blue); }

    private final ObjectProperty<javafx.scene.paint.Color> color = new SimpleObjectProperty<>();
        public javafx.scene.paint.Color getColor() { return color.get(); }
        public ObjectProperty<javafx.scene.paint.Color> colorProperty() { return color; }
        private void setColor(javafx.scene.paint.Color color) { this.color.set(color); }

    ColorVM(Color color) {
        model = color;
        setRed((int) (color.getRed() * 255));
        setGreen((int) (color.getGreen() * 255));
        setBlue((int) (color.getBlue() * 255));
    }

    public Color getModel() {
        return model;
    }
}
