package dao.mappers;

import dao.IRepository;
import domain.Profile;
import domain.Repair;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairMapper implements IMapResultSetIntoEntity<Repair>{
    IRepository<Profile> profileRepo;

    public IRepository<Profile> getPersonRepo() {
        return profileRepo;
    }

    public void setProfileRepo(IRepository<Profile> profileRepo) {
        this.profileRepo = profileRepo;
    }

    public Repair map(ResultSet rs) throws SQLException {
        Repair repair = new Repair();
        repair.setId(rs.getInt("id"));
        repair.setProfileID(rs.getInt("profileid"));
        repair.setNameOfDeviceInRepair(rs.getString("nameOfDevice"));
        repair.setStartRepairDate(rs.getDate("dateOfAcceptance"));
        repair.setStartRepairDate(rs.getDate("expectedDateOfReception"));
        repair.setPrice(rs.getInt("price"));
        if(profileRepo!=null)
            repair.setProfile(this.profileRepo.get(repair.getProfileID()));
        return repair;
    }
}
