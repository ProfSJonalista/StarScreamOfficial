package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@XmlRootElement
public class RepairDto {
    private int Id;
    private int ProfileID;
    private int Price;
    private Date StartRepairDate;
    private Date EndRepairDate;
    private String NameOfDeviceInRepair;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
