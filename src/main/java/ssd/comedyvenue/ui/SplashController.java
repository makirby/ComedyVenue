package ssd.comedyvenue.ui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ssd.comedyvenue.model.*;
import ssd.comedyvenue.model.Event;
import ssd.comedyvenue.repository.EventRepository;
import ssd.comedyvenue.repository.Repository;

import java.awt.*;
import java.awt.List;
import java.util.*;

import javafx.collections.ObservableList;

import javax.swing.event.ChangeEvent;

public class SplashController{

    // ui elements
//    @FXML public TableView eventsList;
//    @FXML public TableColumn eventNameCol;

    @FXML public ListView EventsList;

    @FXML public TextField eventName;
    @FXML public TextField eventDate;
    @FXML public TextField eventCap;
    @FXML public TextField eventComedian;
    @FXML public TextField eventMinAge;
    @FXML public CheckBox newEvent;
    @FXML public TableView eventFeedback;
    @FXML public Label eventAudStats;
    @FXML public Button updateEventButton;

    @FXML public TextField comedianName;
    @FXML public TextField stageName;
    @FXML public TextField comedianNumber;
    @FXML public CheckBox newComedian;
    @FXML public Button updateComedianButton;
    @FXML public Tab organiserTab;


    public SplashController(){}

    // access to event
    private Repository<Event> eventRepository;
    // access comedians
    private Repository<Comedian> comedianRepository;



//    tp = tv.getFocusModel().getFocusedCell();

    public void refreshEvents(ActionEvent actionEvent) {

//        ObservableList<Event> events = (ObservableList<Event>) eventRepository.list();

//        eventsList.getItems().setAll(events);
//        eventsList.setItems(events);


//


//        EventsList.setItems(items);
    }


    /// needs table cell click event




    public void updateEvent(ActionEvent actionEvent) {

        eventRepository = new EventRepository();

        if(newEvent.isSelected()){

            /// add event
            Event event = new Event();

            event.setName(eventName.getText());
//            event.setDate(Date(eventDate.getText()));
            event.setCapacity(Integer.parseInt(eventCap.getText()));
//            event.setComedian( get comedian );

            eventRepository.add(event);

        }else{

            /// update event

            // Event event = get event from table

//            event.setName(eventName.getText());
//            event.setDate(Date(eventDate.getText()));
//            event.setCapacity(Integer.parseInt(eventCap.getText()));
//            event.setComedian( get comedian );

//            eventRepository.update(event);
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
