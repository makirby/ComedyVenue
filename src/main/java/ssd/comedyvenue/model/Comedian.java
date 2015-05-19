package ssd.comedyvenue.model;

import javax.persistence.*;

@Entity
@Table(name = "Comedian")
public class Comedian {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    private String name;
    private String stageName;
    private String contactNumber;

    public Comedian(){}

    public Comedian(String name, String stageName, String contactNumber){
        this.name = name;
        this.stageName = stageName;
        this.contactNumber = contactNumber;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
