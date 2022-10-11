package viewmodel;

import javafx.beans.property.*;
import model.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ColorVM implements PropertyChangeListener {

    private Color model;

    private IntegerProperty red = new SimpleIntegerProperty();
    public int getRed() {return red.get();}
    public ReadOnlyIntegerProperty redProperty() {return red;}
    private void setRed(int red) {this.red.set(red);}

    private IntegerProperty green = new SimpleIntegerProperty();
    public int getGreen() {return green.get();}
    public ReadOnlyIntegerProperty greenProperty() {return green;}
    private void setGreen(int green) {this.green.set(green);}

    private IntegerProperty blue = new SimpleIntegerProperty();
    public int getBlue() {return blue.get();}
    public ReadOnlyIntegerProperty blueProperty() {return blue;}
    private void setBlue(int blue) {this.blue.set(blue);}

    private ObjectProperty<javafx.scene.paint.Color> color = new SimpleObjectProperty<>();
        public javafx.scene.paint.Color getColor() {return color.get();}
        public ObjectProperty<javafx.scene.paint.Color> colorProperty() {return color;}
        private void setColor(javafx.scene.paint.Color color) {this.color.set(color);}

    ColorVM(int red, int green, int blue) {
        color.addListener((obs,old,newV)-> {
            setRed((int)(newV.getRed()*255));
            setGreen((int)(newV.getGreen()*255));
            setBlue((int)(newV.getBlue()*255));
        });
        color.set(new javafx.scene.paint.Color(red/255.,green/255.,blue/255.,1));
        model = new Color(red, green, blue);
        model.addListener(this);
    }

    ColorVM(List<Integer> list) {
        this(list.get(0), list.get(1), list.get(2));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropagationId() == Color.redID) {
            red.set((int) evt.getNewValue());
        } else if (evt.getPropagationId() == Color.greenID) {
            green.set((int) evt.getNewValue());
        } else if (evt.getPropagationId() == Color.blueID) {
            blue.set((int) evt.getNewValue());
        }
    }
}
