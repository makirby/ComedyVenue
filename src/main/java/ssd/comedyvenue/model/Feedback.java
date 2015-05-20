package ssd.comedyvenue.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "feedback")
public class Feedback {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, foreign = true)
    private Customer customer;
    @DatabaseField(canBeNull = false, foreign = true)
    private Booking booking;
    @DatabaseField
    private String comments;
    @DatabaseField
    private Integer rating;

    public Feedback() {}

    public Feedback(Customer customer, Booking booking, String comments, Integer rating) {
        this.customer = customer;
        this.booking = booking;
        this.comments = comments;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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
}
