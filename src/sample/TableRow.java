package sample;


import java.io.File;
import java.time.LocalDate;

public class TableRow {

    private int id;

    private String description;

    private LocalDate date;

    //TODO just a stub, implement actual data later
    private File image;

    private boolean state;

    public TableRow() {
    }

    public TableRow(int id, String description, LocalDate date, File image,
                    boolean state) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.image = image;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
