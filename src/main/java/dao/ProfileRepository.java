package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.uow.IUnitOfWork;
import domain.Profile;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProfileRepository extends RepositoryBase<Profile>
        implements IProfileRepository{

    public ProfileRepository(Connection connection,
                            IMapResultSetIntoEntity<Profile> mapper,
                            IUnitOfWork uow) {
        super(connection, mapper,uow);
    }

    @Override
    protected String tableName() {
        return "Profile";
    }

    @Override
    protected String createTableSql() {
        return "CREATE TABLE Profile(" +
                "ID int GENERATED BY DEFAULT AS IDENTITY," +
                "Name VARCHAR (30)," +
                "Surname VARCHAR(40)," +
                "Email VARCHAR(50)," +
                "Password VARCHAR (18)," +
                "TotalPrice int" +
                ")";
    }

    @Override
    protected String insertSql() {
        return "INSERT INTO Profile(Name, Surname, Email, Password, TotalPrice) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String updateSql() {
        return "UPDATE Profile set Name = ?, Surname = ?, Email = ?, Password = ?, TotalPrice = ?";
    }

    @Override
    protected void setupInsert(Profile entity) throws SQLException{
        insert.setString(1, entity.getName());
        insert.setString(2, entity.getSurname());
        insert.setString(3, entity.getEmail());
        insert.setString(4, entity.getPassword());
        insert.setInt(5, entity.getTotalPrice());
    }

    @Override
    protected void setupUpdate(Profile entity) throws SQLException{
        update.setString(1, entity.getName());
        update.setString(2, entity.getSurname());
        update.setString(3, entity.getEmail());
        update.setString(4, entity.getPassword());
        update.setInt(5, entity.getTotalPrice());
        update.setInt(6, entity.getId());
    }

    public List<Profile> withName(String name) {
        return null;
    }
}
