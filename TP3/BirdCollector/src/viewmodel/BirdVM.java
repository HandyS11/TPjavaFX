package viewmodel;

import javafx.beans.property.*;

import java.time.LocalDate;

public class BirdVM {

    private StringProperty name = new SimpleStringProperty();
    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }
    public void setName(String name) { this.name.set(name); }

    private IntegerProperty hungerStrength = new SimpleIntegerProperty();
    public int getHungerStrength() { return hungerStrength.get(); }
    public IntegerProperty hungerStrengthProperty() { return hungerStrength; }
    public void setHungerStrength(int hungerStrength) { this.hungerStrength.set(hungerStrength); }

    LocalDate lastMealDate;
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>(lastMealDate);
    public LocalDate getDate() { return date.get(); }
    public ObjectProperty<LocalDate> dateProperty() { return date; }
    public void setDate(LocalDate date) { this.date.set(date); }

    private BooleanProperty needEat = new SimpleBooleanProperty(false);
    public boolean isNeedEat() { return needEat.get(); }
    public BooleanProperty needEatProperty() { return needEat; }
    public void setNeedEat(boolean needEat) { this.needEat.set(needEat); }

    public BirdVM(String name, int hungerStrength) {
        setName(name);
        setHungerStrength(hungerStrength);
        setDate(LocalDate.now());
    }
}
