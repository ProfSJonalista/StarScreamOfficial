package dao;

import dao.mappers.ProfileMapper;
import dao.mappers.RepairMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog{

    IUnitOfWork uow;
    Connection connection;

    public RepositoryCatalog(String url) throws SQLException, ClassNotFoundException {
        super();

        Class.forName("org.hsqldb.jdbcDriver");
        this.connection = DriverManager.getConnection(url);
        this.uow = new UnitOfWork(this.connection);
    }

    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        super();
        this.uow = uow;
        this.connection = connection;
    }


    public IProfileRepository profiles() {
        return new ProfileRepository(this.connection, new ProfileMapper(), this.uow);
    }

    public IRepairRepository repairs() {
        return new RepairRepository(this.connection, new RepairMapper(), profiles(), this.uow);
    }

    public void saveAndClose() {
        try{
            this.uow.commit();
            this.connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void save() {
        try {
            this.uow.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
