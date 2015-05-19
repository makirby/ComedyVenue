package ssd.comedyvenue.dao;

import org.hibernate.SessionFactory;
import ssd.comedyvenue.model.Feedback;

import java.util.List;


public interface FeedbackDAO {
    void setSessionFactory(SessionFactory sessionFactory);

    void addFeedback(Feedback feedback);

    void updateFeedback(Feedback feedback);

    List<Feedback> listFeedback();

    Feedback getFeedbackById(int id);

    void removeFeedback(int id);
}
