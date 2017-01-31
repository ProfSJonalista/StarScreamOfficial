package dao.mappers;

import domain.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileMapper implements IMapResultSetIntoEntity<Profile>{
    public Profile map(ResultSet rs) throws SQLException {
        Profile p = new Profile();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setSurname(rs.getString("surname"));
        return p;
    }
}
