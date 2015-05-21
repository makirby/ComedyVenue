package ssd.comedyvenue.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "feedback")
public class Feedback {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, foreign = true)
    private Event event;
    @DatabaseField
    private String comments;
    @DatabaseField
    private Integer rating;

    public Feedback() {}

    public Feedback( Event event, String comments, Integer rating) {
        this.event = event;
        this.comments = comments;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getBooking() {
        return event;
    }

    public void setBooking(Event event) {
        this.event = event;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return this.rating + "/5 " + this.comments;
    }
}
