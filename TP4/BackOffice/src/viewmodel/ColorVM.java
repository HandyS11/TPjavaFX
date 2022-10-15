package viewmodel;

import javafx.beans.property.*;
import model.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ColorVM implements PropertyChangeListener {

    private Color model;

    private final IntegerProperty red = new SimpleIntegerProperty();
        public int getRed() {return red.get();}
        public ReadOnlyIntegerProperty redProperty() {return red;}
        private void setRed(int red) {this.red.set(red);}

    private final IntegerProperty green = new SimpleIntegerProperty();
        public int getGreen() {return green.get();}
        public ReadOnlyIntegerProperty greenProperty() {return green;}
        private void setGreen(int green) {this.green.set(green);}

    private final IntegerProperty blue = new SimpleIntegerProperty();
        public int getBlue() {return blue.get();}
        public ReadOnlyIntegerProperty blueProperty() {return blue;}
        private void setBlue(int blue) {this.blue.set(blue);}

    private final ObjectProperty<javafx.scene.paint.Color> color = new SimpleObjectProperty<>();
        public javafx.scene.paint.Color getColor() {return color.get();}
        public ObjectProperty<javafx.scene.paint.Color> colorProperty() {return color;}
        private void setColor(javafx.scene.paint.Color color) {this.color.set(color);}

    ColorVM(Color color) {
        model = color;
        setRed(color.getRed());
        setGreen(color.getGreen());
        setBlue(color.getBlue());

        model.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(String.valueOf(Color.PROP_RED))) {
            red.set((int) evt.getNewValue());
        } else if (evt.getPropertyName().equals(String.valueOf(Color.PROP_GREEN))) {
            green.set((int) evt.getNewValue());
        } else if (evt.getPropertyName().equals(String.valueOf(Color.PROP_BLUE))) {
            blue.set((int) evt.getNewValue());
        }
    }

    public Color getModel() {
        return model;
    }
}
