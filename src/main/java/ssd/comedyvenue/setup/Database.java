package ssd.comedyvenue.setup;

import com.j256.ormlite.table.TableUtils;
import org.joda.time.DateTime;
import ssd.comedyvenue.model.*;
import ssd.comedyvenue.repository.*;
import ssd.comedyvenue.util.ConnectionProvider;

public class Database {

    Repository<Comedian> comedianRepo = new ComedianRepository();
    Repository<Customer> customerRepo = new CustomerRepository();
    Repository<Event> eventRepo = new EventRepository();
    Repository<Booking> bookingRepo = new BookingRepository();



    /* Creates database tables and seeds with a set of information */
    public void init(){

        try {
            //setup database tables
            createTables();

            //seed customers
            createCustomers();

            //seed comedians
            createComedians();

            //seed events
            createEvents();

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


        customerRepo.add(customer1);
        customerRepo.add(customer2);
        customerRepo.add(customer3);
        customerRepo.add(customer4);
        customerRepo.add(customer5);

    }

    private void createComedians(){

        Comedian comedian1 = new Comedian("Jimbo Jones", "Jim The Clown", "07239237421");
        Comedian comedian2 = new Comedian("Tom Jones", "Hurricane Fly", "07239237421");
        Comedian comedian3 = new Comedian("Bruce Springsteen", "Seabiscuit", "07239237421");
        Comedian comedian4 = new Comedian("Ian Witten", "Jack Dexter", "07239237421");
        Comedian comedian5 = new Comedian("Dean Mumm", "Madame Chang", "07239237421");


        comedianRepo.add(comedian1);
        comedianRepo.add(comedian2);
        comedianRepo.add(comedian3);
        comedianRepo.add(comedian4);
        comedianRepo.add(comedian5);

    }

    private void createEvents(){

        DateTime now = DateTime.now();
        Comedian comedian = comedianRepo.list().get(1);

        Event event1 = new Event(comedian, "The Big Show", 30, now.plusDays(10).toDate(), 21);
        Event event2 = new Event(comedian, "The Bigger Show", 30, now.plusDays(15).toDate(), 21);
        Event event3 = new Event(comedian, "A Small Show", 150, now.plusDays(30).toDate(), 21);

        eventRepo.add(event1);
        eventRepo.add(event2);
        eventRepo.add(event3);

    }
}
