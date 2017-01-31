import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.Profile;
import domain.Repair;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main( String[] args ){
        String URL = "jdbc:hsqldb:hsql://localhost/workdb";

        try {
            Connection connection = DriverManager.getConnection(URL);

            //IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

            IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

            Repair device = new Repair();

            device.setProfileID(0);
            device.setStartRepairDate(new Date(116, 9, 10));
            device.setEndRepairDate(new Date(116, 9, 11));
            device.setNameOfDeviceInRepair("Samsung");
            device.setPrice(50);

            catalog.repairs().add(device);

            Profile profile = new Profile();
            profile.setName("Jan");
            profile.setSurname("Miętki");
            profile.setEmail("email@gmail.com");
            profile.setPassword("qwerty");
            profile.setTotalPrice(50);

            catalog.profiles().add(profile);

            System.out.println("Zapisuję profil");

            //List<Repair> repairs = catalog.repairs().repairs("Samsung");

            System.out.println("Zapisuję urządzenie");

            catalog.saveAndClose();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("The end");
    }
}
