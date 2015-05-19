package ssd.comedyvenue.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ssd.comedyvenue.model.Booking;
import ssd.comedyvenue.repository.Repository;

import java.util.List;

@Component
public class Startup {

    private Repository<Booking> bookingRepository;

    @Autowired(required=true)
    @Qualifier(value="bookingService")
    public void setPersonService(Repository bookingRepo) {
        this.bookingRepository = bookingRepo;
    }

    
//    public void BootstrapUi(){
//
//        List<Booking> bookingList =  bookingRepository.list();
//
//    }

}
