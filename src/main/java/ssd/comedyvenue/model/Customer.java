package ssd.comedyvenue.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "customer")
public class Customer {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String contact;

    public Customer(){}

    public Customer(String name, String contact){
        this.name = name;
        this.contact = contact;
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


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
