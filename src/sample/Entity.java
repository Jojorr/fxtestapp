package sample;

import javafx.beans.property.*;

public class Entity {

    private IntegerProperty id;

    private StringProperty description;

    private LongProperty date;

    //TODO just a stub, implement actual data later
    private StringProperty image;

    private BooleanProperty state;

    public Entity() {
        this(0, null, (long) 0, "", true);
    }

    public Entity(int id, String description, Long date, String image,
                  boolean state) {
        this.id = new SimpleIntegerProperty(id);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleLongProperty(date);
        this.image = new SimpleStringProperty(image);
        this.state = new SimpleBooleanProperty(state);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public long getDate() {
        return date.get();
    }

    public void setDate(long date) {
        this.date.setValue(date);
    }

    public String getImage() {
        return image.get();
    }

    public void setImage(String  image) {
        this.image.setValue(image);
    }

    public boolean isState() {
        return state.get();
    }

    public void setState(boolean state) {
        this.state.setValue(state);
    }
}
