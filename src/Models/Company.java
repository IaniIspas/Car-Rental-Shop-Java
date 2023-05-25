package Models;

import java.util.List;
import java.util.Map;

public class Company {
    private int id;
    private String name;
    private Address address;

    public Company() {
    }

    public Company(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


