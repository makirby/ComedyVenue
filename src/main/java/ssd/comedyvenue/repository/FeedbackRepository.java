package ssd.comedyvenue.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import ssd.comedyvenue.model.Feedback;
import ssd.comedyvenue.util.ConnectionProvider;

import java.sql.SQLException;
import java.util.List;

public class FeedbackRepository implements Repository<Feedback> {

    Dao<Feedback, Integer> feedbackDao;

    public FeedbackRepository(){

        try {
            this.feedbackDao = DaoManager.createDao(ConnectionProvider.getConnection(), Feedback.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Feedback entity){

        try {
            this.feedbackDao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Feedback entity){

        try {
            this.feedbackDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> list(){

        try {
            return this.feedbackDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Feedback getById(int id){

        try {
            return this.feedbackDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(int id){

        try {
            this.feedbackDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
