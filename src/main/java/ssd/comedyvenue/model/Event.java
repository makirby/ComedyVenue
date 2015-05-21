package ssd.comedyvenue.model;

import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "event")
public class Event {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Comedian comedian;
    @DatabaseField
    private String name;
    @DatabaseField
    private Date date;
    @DatabaseField
    private Integer restriction;
    @DatabaseField
    private Integer capacity;

    @ForeignCollectionField
    private ForeignCollection<Booking> bookings;

    @ForeignCollectionField
    private ForeignCollection<Feedback> feedback;

    public Event(){}

    public Event(Comedian comedian, String name, Integer capacity, Date date, Integer restriction){
        this.comedian = comedian;
        this.name = name;
        this.capacity = capacity;
        this.restriction = restriction;
        this.date = date;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Comedian getComedian(){
        return comedian;
    }

    public void setComedian(Comedian comedian){
        this.comedian = comedian;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Integer getRestriction() {
        return restriction;
    }

    public void setRestriction(Integer restriction) {
        this.restriction = restriction;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public ForeignCollection<Booking> getBookings(){
        return this.bookings;
    }

    public void setBookings(ForeignCollection<Booking> bookings){
        this.bookings = bookings;
    }

    public ForeignCollection<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(ForeignCollection<Feedback> feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
