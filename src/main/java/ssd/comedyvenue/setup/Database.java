package ssd.comedyvenue.setup;

import com.j256.ormlite.table.TableUtils;
import org.joda.time.DateTime;
import ssd.comedyvenue.model.*;
import ssd.comedyvenue.repository.CustomerRepository;
import ssd.comedyvenue.repository.Repository;
import ssd.comedyvenue.util.ConnectionProvider;

public class Database {

    /* Creates database tables and seeds with a set of information */
    public void init(){

        try {
            //setup database tables
            createTables();

            //seed customers
            createCustomers();

            //seed comedians
            createComedians();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createTables() throws Exception{
        //Create tables in DB
        TableUtils.createTable(ConnectionProvider.getConnection(), Booking.class);
        TableUtils.createTable(ConnectionProvider.getConnection(), Comedian.class);
        TableUtils.createTable(ConnectionProvider.getConnection(), Customer.class);
        TableUtils.createTable(ConnectionProvider.getConnection(), Event.class);
        TableUtils.createTable(ConnectionProvider.getConnection(), Feedback.class);
    }

    private void createCustomers(){

        DateTime now = DateTime.now();
        Customer customer1 = new Customer("John Smith", now.minusYears(34).toDate() ,"087916273812");
        Customer customer2 = new Customer("Alan Hutton", now.minusYears(19).toDate() ,"082146278719");
        Customer customer3 = new Customer("Gordon Banks", now.minusYears(54).toDate() ,"084848278719");
        Customer customer4 = new Customer("Jack Charlton", now.minusYears(62).toDate() ,"084246375719");
        Customer customer5 = new Customer("Peter Shilton", now.minusYears(29).toDate() ,"081646278719");

        Repository<Customer> customerRepo = new CustomerRepository();

        customerRepo.add(customer1);
        customerRepo.add(customer2);
        customerRepo.add(customer3);
        customerRepo.add(customer4);
        customerRepo.add(customer5);

    }

    private void createComedians(){

    }
}
