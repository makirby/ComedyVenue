package ssd.comedyvenue.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "comedian")
public class Comedian {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String stageName;
    @DatabaseField
    private String contact;

    public Comedian(){}

    public Comedian(String name, String stageName, String contact){
        this.name = name;
        this.stageName = stageName;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getContactNumber() {
        return contact;
    }

    public void setContactNumber(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
