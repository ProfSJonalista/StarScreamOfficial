package domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "repair.all", query = "SELECT r FROM Repair r"),
        @NamedQuery(name = "repair.id", query = "SELECT r FROM Repair r WHERE r.Id=:id"),
        @NamedQuery(name = "repair.byProfile", query = "SELECT r FROM Repair r WHERE r.ProfileID=:profile_Id")
})
public class Repair implements IHaveId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int ProfileID;
    private int Price;
    private Date StartRepairDate;
    private Date EndRepairDate;
    private String NameOfDeviceInRepair;
    @ManyToOne
    private Profile profile;

    public int getId() {
        return Id;
    }

    public void setId(int ID) {
        this.Id = ID;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Date getStartRepairDate() {
        return StartRepairDate;
    }

    public void setStartRepairDate(Date startRepairDate) {
        StartRepairDate = startRepairDate;
    }

    public Date getEndRepairDate() {
        return EndRepairDate;
    }

    public void setEndRepairDate(Date endRepairDate) {
        EndRepairDate = endRepairDate;
    }

    public String getNameOfDeviceInRepair() {
        return NameOfDeviceInRepair;
    }

    public void setNameOfDeviceInRepair(String nameOfDeviceInRepair) {
        NameOfDeviceInRepair = nameOfDeviceInRepair;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
