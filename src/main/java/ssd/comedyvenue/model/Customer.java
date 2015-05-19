package ssd.comedyvenue.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    private String name;
    private Date dob;

    public Customer(){}

    public Customer(String name, Date dob){
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
