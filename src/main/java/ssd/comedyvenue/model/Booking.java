package ssd.comedyvenue.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "booking")
public class Booking {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Customer customer;
    @DatabaseField
    private Integer seats;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Event event;
    @DatabaseField(foreign = true)
    private Feedback feedback;
    @DatabaseField
    private Boolean canceled;

    public Booking(){}

    public Booking(Customer customer, Integer seats, Event event){
        this.customer = customer;
        this.seats = seats;
        this.event = event;
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

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

}
