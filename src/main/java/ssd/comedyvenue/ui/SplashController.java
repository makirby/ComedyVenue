package ssd.comedyvenue.ui;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.joda.time.DateTime;
import ssd.comedyvenue.model.*;
import ssd.comedyvenue.model.Event;
import ssd.comedyvenue.repository.*;


import javafx.collections.ObservableList;

import javax.swing.event.ChangeEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SplashController{

    // ui elements
//    @FXML public TableView eventsList;
//    @FXML public TableColumn eventNameCol;



    @FXML public TextField eventName;
    @FXML public DatePicker eventDate;
    @FXML public TextField eventCap;
    @FXML public TextField eventMinAge;
    @FXML public CheckBox newEvent;
    @FXML public TableView eventFeedback;
    @FXML public Label eventAudStats;
    @FXML public ComboBox eventComedianCombo;
    @FXML public Button updateEventButton;

    @FXML public TextField comedianName;
    @FXML public TextField stageName;
    @FXML public TextField comedianNumber;
    @FXML public CheckBox newComedian;
    @FXML public Button updateComedianButton;
    @FXML public Tab organiserTab;

    @FXML public ListView EventsList;

    @FXML public void handleMouseClick(MouseEvent arg0) {

        Event event = new Event();

        event = (Event) EventsList.getSelectionModel().getSelectedItem();

        DateTime date = new DateTime(event.getDate());

        eventName.setText(event.getName());
        eventDate.setValue(LocalDate.of(date.getYear(),date.getMonthOfYear(),
            date.getDayOfMonth()));
        eventCap.setText(event.getCapacity().toString());
        eventMinAge.setText(event.getRestriction().toString());
        eventComedianCombo.getSelectionModel().select(event.getComedian().getName());


    }


    public SplashController(){}

    // access to event
    private Repository<Event> eventRepository = new EventRepository();
    // access comedians
    private Repository<Comedian> comedianRepository = new ComedianRepository();
    //access customer
    private  Repository<Customer> customerRepository = new CustomerRepository();
    //access Bookings
    private  Repository<Booking> bookingRepository = new BookingRepository();
    //access Feedback
    private  Repository<Feedback> feedbackRepoistory = new FeedbackRepository();



//    tp = tv.getFocusModel().getFocusedCell();

    public void refreshEvents(ActionEvent actionEvent) {

        List<Event> eventList = eventRepository.list();

        ObservableList<Event> events = FXCollections.observableArrayList(eventList);

        EventsList.setItems(events);


        List<Comedian> comedianList = comedianRepository.list();

        ObservableList<Comedian> comedians = FXCollections.observableArrayList(comedianList);

        eventComedianCombo.setItems(comedians);
    }






    public void updateEvent(ActionEvent actionEvent) throws ParseException {

        eventRepository = new EventRepository();

        Event event = new Event();

        if(!newEvent.isSelected()) {
            event = (Event) EventsList.getSelectionModel().getSelectedItem();
        }

            event.setName(eventName.getText());

            DateTime date = new DateTime(eventDate.getValue());
            event.setDate(date.toDate());

            event.setCapacity(Integer.parseInt(eventCap.getText()));
            event.setCapacity(Integer.parseInt(eventCap.getText()));
            event.setComedian((Comedian) eventComedianCombo.getSelectionModel().getSelectedItem());


        if(newEvent.isSelected()){

            /// add event
            eventRepository.add(event);

        }else{

            /// update event
            eventRepository.update(event);
        }

    }


    public void updateComedian(ActionEvent event){

        if(newComedian.isSelected()){

            Comedian comedian = new Comedian();

            comedian.setName(comedianName.getText());
            comedian.setStageName(stageName.getText());
            comedian.setContactNumber(comedianNumber.getText());

        }else {


        }



    }


}
