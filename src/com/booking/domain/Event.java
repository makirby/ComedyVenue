package com.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event implements java.io.Serializable{

    private Integer id;
    private Comedian comedian;
    private String name;
    private Set<Booking> bookings = new HashSet<Booking>();
    private Date date;
    private Integer capacity;

    public Event(){}

    public Event(Comedian comedian, String name, Integer capacity, Date date){
        this.comedian = comedian;
        this.name = name;
        this.capacity = capacity;
        this.date = date;
    }

    @Id
    @GeneratedValue
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    public Set<Booking> getBookings(){
        return this.bookings;
    }

    public void setBookings(Set<Booking> bookings){
        this.bookings = bookings;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }
}
