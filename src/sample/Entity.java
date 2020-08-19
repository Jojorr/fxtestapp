package sample;

import javafx.beans.property.*;

import java.io.File;
import java.util.Date;

public class Entity {

    private IntegerProperty id;

    private StringProperty description;

    private LongProperty date;

    private ObjectProperty<File> image;

    private BooleanProperty state;

    public Entity() {
    }

    public Entity(int id, String description, Date date, File image,
                  boolean state) {
        this.id = new SimpleIntegerProperty(id);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleLongProperty(date.getTime());
        this.image = new SimpleObjectProperty<>(image);
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

    public Date getDate() {
        return new Date(date.get());
    }

    public void setDate(Date date) {
        this.date.setValue(date.getTime());
    }

    public File getImage() {
        return image.get();
    }

    public void setImage(File image) {
        this.image.setValue(image);
    }

    public boolean isState() {
        return state.get();
    }

    public void setState(boolean state) {
        this.state.setValue(state);
    }
}
