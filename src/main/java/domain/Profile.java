package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "profile.all", query = "SELECT p FROM Profile p"),
        @NamedQuery(name = "profile.id", query = "SELECT p FROM Profile p WHERE p.Id=:profileId")
})
public class Profile implements IHaveId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Surname;

    @OneToMany(mappedBy = "profile")
    private List<Repair> DevicesInRepair = new ArrayList<Repair>();
    private String Email;
    private String Password;
    private int TotalPrice;

    public int getId() {
        return Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Repair> getDevicesInRepair() {
        return DevicesInRepair;
    }

    public void setDevicesInRepair(List<Repair> devicesInRepair) {
        DevicesInRepair = devicesInRepair;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }
}
