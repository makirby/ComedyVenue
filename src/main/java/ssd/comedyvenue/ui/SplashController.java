package ssd.comedyvenue.ui;


import com.j256.ormlite.dao.ForeignCollection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
    @FXML public TextField eventName;
    @FXML public DatePicker eventDate;
    @FXML public TextField eventCap;
    @FXML public TextField eventMinAge;
    @FXML public CheckBox newEvent;
    @FXML public ListView eventFeedback;
    @FXML public Label eventBookedSeats;
    @FXML public ComboBox eventComedianCombo;
    @FXML public Button updateEventButton;
    @FXML public Label noFeedbackLbl;
    @FXML public ImageView eventImage;
    @FXML public ImageView comedianImage;

    @FXML public TextField comedianName;
    @FXML public TextField stageName;
    @FXML public TextField comedianNumber;
    @FXML public CheckBox newComedian;
    @FXML public Button updateComedianButton;
    @FXML public Tab organiserTab;

    @FXML public ListView EventsList;
    @FXML public ListView ComedianList;
    @FXML public ListView bookingList;

    @FXML public ListView EventsListClerk;

    @FXML public Label eventComedianLbl;
    @FXML public Label eventNameLbl;
    @FXML public Label eventDateLbl;
    @FXML public Label eventCapLbl;
    @FXML public Label eventMinAgeLbl;
    @FXML public Button updateBookingButton;
    @FXML public TextArea userFeedback;
    @FXML public TextField userRating;
    @FXML public TextField bookingName;
    @FXML public TextField bookingNumber;
    @FXML public TextField bookingSeats;
    @FXML public CheckBox bookingAgeConfirmedCheckbox;
    @FXML public CheckBox newBooking;
    @FXML public CheckBox cancelBooking;
    @FXML public Label noBookingsLbl;
    @FXML public ImageView bookingImage;


    @FXML public Button updateFeedbackButton;

    @FXML public ImageView feedbackImage;

    @FXML public void selectEventClick(MouseEvent arg0) {

        Event event = (Event) EventsList.getSelectionModel().getSelectedItem();

        DateTime date = new DateTime(event.getDate());

        eventName.setText(event.getName());
        eventDate.setValue(LocalDate.of(date.getYear(),date.getMonthOfYear(),
            date.getDayOfMonth()));
        eventCap.setText(event.getCapacity().toString());
        eventMinAge.setText(event.getRestriction().toString());
        eventComedianCombo.getSelectionModel().select(event.getComedian());

        ForeignCollection<Feedback> feedbackList = event.getFeedback();
        ObservableList<Feedback> feedback = FXCollections.observableArrayList(feedbackList);
        if(feedback.size() == 0){
            noFeedbackLbl.setVisible(true);
        }else{
            noFeedbackLbl.setVisible(false);
        }

        eventFeedback.setItems(feedback);

        ForeignCollection<Booking> bookingList = event.getBookings();
        Integer seats = 0;
        for(Booking booking: bookingList){

            if(!booking.getCanceled()){

                seats = seats + booking.getSeats();
            }
        }

        eventBookedSeats.setText(seats.toString());

        newEvent.setSelected(false);
        updateEventButton.setText("UPDATE");
    }

    @FXML public void selectComedianClick(MouseEvent arg0) {

        Comedian comedian = (Comedian) ComedianList.getSelectionModel().getSelectedItem();

        comedianName.setText(comedian.getName());
        comedianNumber.setText(comedian.getContactNumber());
        stageName.setText(comedian.getStageName());

        newComedian.setSelected(false);
        updateComedianButton.setText("UPDATE");
    }


    @FXML public void selectEventClerkClick(MouseEvent arg0) {

        Event event = (Event) EventsListClerk.getSelectionModel().getSelectedItem();

        DateTime date = new DateTime(event.getDate());

        eventNameLbl.setText(event.getName());
        eventDateLbl.setText(event.getDate().toString());
        eventCapLbl.setText(event.getCapacity().toString());
        eventMinAgeLbl.setText(event.getRestriction().toString());
        eventComedianLbl.setText(event.getComedian().getName());

        ForeignCollection<Booking> bookinglist = event.getBookings();

        ObservableList<Booking> bookings = FXCollections.observableArrayList(bookinglist);
        if(bookings.size() == 0){

            noBookingsLbl.setVisible(true);
        }else{
            noBookingsLbl.setVisible(false);
        }

        bookingList.setItems(bookings);

        newBooking.setSelected(false);
        bookingAgeConfirmedCheckbox.setSelected(false);
        bookingAgeConfirmedCheckbox.setVisible(false);

        updateBookingButton.setDisable(false);
        updateBookingButton.setText("UPDATE");

        updateFeedbackButton.setDisable(false);
    }

    @FXML public void selectBookingClick(MouseEvent arg0){

        Booking booking = (Booking) bookingList.getSelectionModel().getSelectedItem();

        bookingName.setText(booking.getCustomer().getName());
        bookingNumber.setText(booking.getCustomer().getContact());
        bookingSeats.setText(booking.getSeats().toString());

        cancelBooking.setSelected(booking.getCanceled());

        newBooking.setSelected(false);
        bookingAgeConfirmedCheckbox.setSelected(false);
        bookingAgeConfirmedCheckbox.setVisible(false);

        updateBookingButton.setDisable(false);
        updateBookingButton.setText("UPDATE");
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



    public void refreshAllData(ActionEvent actionEvent) {

        refreshEventData();
        refreshComedianData();
    }

    public void refreshEventData(){

        /// load events
        List<Event> eventList = eventRepository.list();

        ObservableList<Event> events = FXCollections.observableArrayList(eventList);

        EventsList.setItems(events);
        EventsListClerk.setItems(events);
    }

    public void refreshComedianData(){

        /// event comedian drop down
        List<Comedian> comedianList = comedianRepository.list();

        ObservableList<Comedian> comedians = FXCollections.observableArrayList(comedianList);

        eventComedianCombo.setItems(comedians);
        ComedianList.setItems(comedians);
    }

    public void refreshBookingData(){

        Event event = (Event) EventsListClerk.getSelectionModel().getSelectedItem();

        ForeignCollection<Booking> bookinglist = event.getBookings();

        ObservableList<Booking> bookings = FXCollections.observableArrayList(bookinglist);
        if(bookings.size() == 0){

            noBookingsLbl.setVisible(true);
        }else{
            noBookingsLbl.setVisible(false);
        }

        bookingList.setItems(bookings);
    }

    public void newEventCheckedboxClicked(ActionEvent e){

        EventsList.getSelectionModel().clearSelection();
        eventFeedback.getItems().clear();
        eventBookedSeats.setText("");

        if(newEvent.isSelected()){
            updateEventButton.setText("ADD");
        }else{
            updateEventButton.setText("UPDATE");
        }
    }

    public void newComedianCheckedboxClicked(ActionEvent e){

        ComedianList.getSelectionModel().clearSelection();

        if(newComedian.isSelected()){
            updateComedianButton.setText("ADD");
        }else{
            updateComedianButton.setText("UPDATE");
        }
    }

    public void newBookingCheckboxClicked(ActionEvent e){

        bookingList.getSelectionModel().clearSelection();

        if(newBooking.isSelected()){

            updateBookingButton.setDisable(true);
            updateBookingButton.setText("CONFIRM CUSTOMER AGE");
            bookingAgeConfirmedCheckbox.setSelected(false);
            bookingAgeConfirmedCheckbox.setVisible(true);

        }else{

            updateBookingButton.setDisable(false);
            updateBookingButton.setText("UPDATE");
            bookingAgeConfirmedCheckbox.setSelected(false);
            bookingAgeConfirmedCheckbox.setVisible(false);
        }

    }

    public void bookingAgeConfirmedCheckboxClicked(ActionEvent e){

        if(bookingAgeConfirmedCheckbox.isSelected()){

            updateBookingButton.setDisable(false);
            updateBookingButton.setText("ADD");

        }else{

            updateBookingButton.setDisable(true);
            updateBookingButton.setText("CONFIRM CUSTOMER AGE");
        }

    }



    public void updateEvent(ActionEvent actionEvent) throws ParseException {

        eventRepository = new EventRepository();

        Event event = new Event();

        if(!newEvent.isSelected()) {
            event = (Event) EventsList.getSelectionModel().getSelectedItem();
        }

            event.setName(eventName.getText());

            DateTime date = new DateTime();

            date.withMonthOfYear(eventDate.getValue().getMonthValue());
            date.withYear(eventDate.getValue().getYear());
            date.withDayOfMonth(eventDate.getValue().getDayOfMonth());
            event.setDate(date.toDate());

            event.setCapacity(Integer.parseInt(eventCap.getText()));
            event.setRestriction(Integer.parseInt(eventMinAge.getText()));


        Comedian com = (Comedian) eventComedianCombo.getSelectionModel().getSelectedItem();
            event.setComedian(com);


        if(newEvent.isSelected()){

            /// add event
            eventRepository.add(event);
            eventName.clear();
            eventDate.getEditor().clear();
            eventCap.clear();
            eventMinAge.clear();
            eventComedianCombo.getSelectionModel().clearSelection();
            newEvent.setSelected(false);

        }else{

            /// update event
            eventRepository.update(event);
        }

        refreshEventData();
        showSuccessImage(eventImage);
    }


    public void updateComedian(ActionEvent event){

        comedianRepository = new ComedianRepository();

        Comedian comedian = new Comedian();

        if(!newComedian.isSelected()) {
            comedian = (Comedian) ComedianList.getSelectionModel().getSelectedItem();
        }

            comedian.setName(comedianName.getText());
            comedian.setStageName(stageName.getText());
            comedian.setContactNumber(comedianNumber.getText());

        if(newComedian.isSelected()){

            /// add event
            comedianRepository.add(comedian);
            comedianName.clear();
            stageName.clear();
            comedianNumber.clear();
            newComedian.setSelected(false);

        }else{

            /// update event
            comedianRepository.update(comedian);
        }

        refreshComedianData();
        showSuccessImage(comedianImage);
    }

    public void updateBooking(ActionEvent actionEvent) throws ParseException {

        bookingRepository = new BookingRepository();

        Booking booking = new Booking();

        if(!newBooking.isSelected()) {
            booking = (Booking) bookingList.getSelectionModel().getSelectedItem();
        }

        booking.setCustomer(checkExists(bookingName.getText(), bookingNumber.getText()));
        booking.setSeats(Integer.parseInt(bookingSeats.getText()));
        booking.setAgeConfirmed(true);
        booking.setCanceled(cancelBooking.isSelected());

        Event event = (Event) EventsListClerk.getSelectionModel().getSelectedItem();

        booking.setEvent(event);

        if(newBooking.isSelected()){

            /// add booking
            bookingRepository.add(booking);
            bookingName.clear();
            bookingNumber.clear();
            bookingSeats.clear();
            cancelBooking.setSelected(false);
            newBooking.setSelected(false);
            bookingAgeConfirmedCheckbox.setSelected(false);
            bookingAgeConfirmedCheckbox.setVisible(false);
            updateBookingButton.setDisable(false);
            updateBookingButton.setText("UPDATE");

        }else{

            /// update booking
            bookingRepository.update(booking);
        }

        refreshBookingData();
        showSuccessImage(bookingImage);
    }

    private Customer checkExists(String name, String contact){

        for (Customer customer: customerRepository.list()){

            if (customer.getName().equals(name) && customer.getContact().equals(contact)){
                return customer;
            }

        }

        customerRepository.add( new Customer(name, contact));

        for (Customer customer: customerRepository.list()){

            if (customer.getName().equals(name) && customer.getContact().equals(contact)){
                return customer;
            }

        }

        return null;
    }


    public void updateFeedback(ActionEvent e){

        feedbackRepoistory = new FeedbackRepository();

        Feedback feedback = new Feedback();

        Event event = (Event) EventsListClerk.getSelectionModel().getSelectedItem();
        // this setBooking takes an Event so should be called setEvent
        feedback.setBooking(event);
        feedback.setComments(userFeedback.getText());
        feedback.setRating(Integer.parseInt(userRating.getText()));

        feedbackRepoistory.add(feedback);

        userFeedback.clear();
        userRating.clear();

        showSuccessImage(feedbackImage);
    }


    public void showSuccessImage(final ImageView image){

        image.setVisible(true);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
            new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    image.setVisible(false);
                }
            }));
        timeline.play();
    }

}
