package ssd.comedyvenue.dao;

import ssd.comedyvenue.model.Comedian;

import java.util.List;

public interface ComedianDAO {

    void addComedian(Comedian comedian);
    void updateComedian(Comedian comedian);
    List<Comedian> listComedians();
    Comedian getComedianById(int id);
    void removeComedian(int id);
}
