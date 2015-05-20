package ssd.comedyvenue.setup;

import com.j256.ormlite.support.ConnectionSource;
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
    Repository<Feedback> feedbackRepo = new FeedbackRepository();

    /* Creates database tables and seeds with a set of information */
    public void init(){

        try {

            if(null != ConnectionProvider.getConnection().getDatabaseType()){
                return;
            }

            //setup database tables
            createTables();
            //seed customers
            createCustomers();
            //seed comedians
            createComedians();
            //seed events
            createEvents();
            //seed bookings
            createBookings();
            //seed feedback
            createFeedback();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //creates the database tables
    private void createTables() throws Exception{
        //Create tables in DB
        TableUtils.createTableIfNotExists(ConnectionProvider.getConnection(), Booking.class);
        TableUtils.createTableIfNotExists(ConnectionProvider.getConnection(), Comedian.class);
        TableUtils.createTableIfNotExists(ConnectionProvider.getConnection(), Customer.class);
        TableUtils.createTableIfNotExists(ConnectionProvider.getConnection(), Event.class);
        TableUtils.createTableIfNotExists(ConnectionProvider.getConnection(), Feedback.class);
    }

    //creates a selection of customer entitites and inserts into the database
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

    //creates a selection of comedian entities in the database
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

    //creates a selection of events in the database
    private void createEvents(){

        DateTime now = DateTime.now();
        Comedian comedian1 = comedianRepo.list().get(1);
        Comedian comedian2 = comedianRepo.list().get(2);

        Event event1 = new Event(comedian1, "The Big Show", 30, now.plusDays(10).toDate(), 21);
        Event event2 = new Event(comedian1, "The Bigger Show", 30, now.plusDays(15).toDate(), 21);
        Event event3 = new Event(comedian1, "A Small Show", 150, now.plusDays(30).toDate(), 21);
        Event event4 = new Event(comedian2, "Another Show", 120, now.minusDays(10).toDate(), 16);

        eventRepo.add(event1);
        eventRepo.add(event2);
        eventRepo.add(event3);
        eventRepo.add(event4);
    }

    //creates a selection of bookings in the database
    private void createBookings(){

        Customer customer1 = customerRepo.list().get(2);
        Customer customer2 = customerRepo.list().get(3);
        Event event1 = eventRepo.list().get(1);
        Event event2 = eventRepo.list().get(3);

        Booking booking1 = new Booking(customer1, 1, event1);
        Booking booking2 = new Booking(customer1, 3, event2);
        Booking booking3 = new Booking(customer2, 2, event2);

        bookingRepo.add(booking1);
        bookingRepo.add(booking2);
        bookingRepo.add(booking3);
    }

    //creates a selection of feedback in the database
    private void createFeedback(){

        Booking booking1 = bookingRepo.getById(2);
        Booking booking2 = bookingRepo.getById(3);

        Feedback feedback1 = new Feedback(booking1, "Wow what a great show", 4);
        Feedback feedback2 = new Feedback(booking2, "It was alright", 3);

        feedbackRepo.add(feedback1);
        feedbackRepo.add(feedback2);
    }
}
