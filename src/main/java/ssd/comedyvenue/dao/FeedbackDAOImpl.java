package ssd.comedyvenue.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ssd.comedyvenue.model.Feedback;

import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(feedback);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(feedback);
    }

    @Override
    public List<Feedback> listFeedback() {
        Session session = this.sessionFactory.openSession();
        List<Feedback> feedbackList = session.createQuery("from Feedback").list();
        session.close();
        return feedbackList;
    }

    @Override
    public Feedback getFeedbackById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Feedback feedback = (Feedback) session.load(Feedback.class, new Integer(id));
        return feedback;
    }

    @Override
    public void removeFeedback(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Feedback feedback = (Feedback) session.load(Feedback.class, new Integer(id));
        if(null != feedback){
            session.delete(feedback);
        }
    }
}
