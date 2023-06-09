package model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.Period;

public class Bird {

    private StringProperty name = new SimpleStringProperty();
        public String getName() { return name.get(); }
        public StringProperty nameProperty() { return name; }
        public void setName(String name) { this.name.set(name); }

    private StringProperty wingsColor = new SimpleStringProperty();
        public String getWingsColor() { return wingsColor.get(); }
        public StringProperty wingsColorProperty() { return wingsColor; }
        public void setWingsColor(String wingsColor) { this.wingsColor.set(wingsColor); }

    LocalDate lastMealDate;
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>(lastMealDate);
        public LocalDate getDate() { return date.get(); }
        public ObjectProperty<LocalDate> dateProperty() { return date; }
        public void setDate(LocalDate date) { this.date.set(date); }

    private IntegerProperty hungerStrength = new SimpleIntegerProperty();
        public int getHungerStrength() { return hungerStrength.get(); }
        public IntegerProperty hungerStrengthProperty() { return hungerStrength; }
        public void setHungerStrength(int hungerStrength) { this.hungerStrength.set(hungerStrength); }

    private IntegerProperty timeSinceLastMeal = new SimpleIntegerProperty();
        public int getTimeSinceLastMeal() { return timeSinceLastMeal.get(); }
        public IntegerProperty timeSinceLastMealProperty() { return timeSinceLastMeal; }
        public void setTimeSinceLastMeal(LocalDate date) {
            this.timeSinceLastMeal.set(Period.between(getDate(), date).getDays());
            if (Period.between(getDate(), date).getDays() > getHungerStrength()) {
                setNeedEat(true);
            } else {
                setNeedEat(false);
            }
        }

    private BooleanProperty needEat = new SimpleBooleanProperty(false);
        public boolean isNeedEat() { return needEat.get(); }
        public BooleanProperty needEatProperty() { return needEat; }
        public void setNeedEat(boolean needEat) { this.needEat.set(needEat); }

    public Bird(String name, String wingsColor, int hungerStrength) {
        setName(name);
        setWingsColor(wingsColor);
        setHungerStrength(hungerStrength);
        setDate(LocalDate.now());
        setTimeSinceLastMeal(LocalDate.now());
    }
}
