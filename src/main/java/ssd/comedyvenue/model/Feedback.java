package ssd.comedyvenue.model;

import javax.persistence.*;

@Entity
@Table(name = "Feedback")
public class Feedback {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private Customer customer;
    private Booking booking;
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Booking")
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
}
