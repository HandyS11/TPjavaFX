package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

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

    public Bird(String name, String wingsColor) {
        setName(name);
        setWingsColor(wingsColor);
        setDate(LocalDate.now());
    }
}
