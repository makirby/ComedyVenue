package ssd.comedyvenue.repository;

import org.springframework.transaction.annotation.Transactional;
import ssd.comedyvenue.dao.ComedianDAO;
import ssd.comedyvenue.dao.ComedianDAOImpl;
import ssd.comedyvenue.model.Comedian;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComedianRepository implements Repository<Comedian> {

    private ComedianDAO comedianDAO;

    public ComedianRepository(){
    }

    public void setComedianDAO(ComedianDAO comedianDAO){
        this.comedianDAO = comedianDAO;
    }

    @Override
    @Transactional
    public void add(Comedian entity) {
        this.comedianDAO.addComedian(entity);
    }

    @Override
    @Transactional
    public void update(Comedian entity) {
        this.comedianDAO.updateComedian(entity);
    }

    @Override
    @Transactional
    public List<Comedian> list() {
        return this.comedianDAO.listComedians();
    }

    @Override
    @Transactional
    public Comedian getById(int id) {
        return this.comedianDAO.getComedianById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.comedianDAO.removeComedian(id);
    }
}
