package ssd.comedyvenue.ui;

import org.springframework.beans.factory.annotation.Configurable;
import ssd.comedyvenue.model.Comedian;
import ssd.comedyvenue.repository.ComedianRepository;
import ssd.comedyvenue.repository.Repository;

@Configurable
public class Startup {

    private Repository<Comedian> comedianRepository;

    public Startup(){}

    public void setComedianRepository(Repository<Comedian> comedianRepository) {
        this.comedianRepository = comedianRepository;
    }

    public void createComedian(){

        comedianRepository = new ComedianRepository();

        Comedian comedian = new Comedian("Jim", "Clown Man", "0785312331");

        this.comedianRepository.add(comedian);

    }

}
