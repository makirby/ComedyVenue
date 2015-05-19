package ssd.comedyvenue.model;

import javax.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private Integer seats;
    @OneToOne(fetch = FetchType.LAZY)
    private Event event;
    @OneToOne(fetch = FetchType.LAZY)
    private Feedback feedback;
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

    public String toString(){
        return "id="+id+", customer="+customer.getName()+", seats="+seats.toString()
                +", event="+event.getName()+", cancelled="+canceled.toString();
    }
}
