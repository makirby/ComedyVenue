package ssd.comedyvenue.repository;

import org.springframework.transaction.annotation.Transactional;
import ssd.comedyvenue.dao.FeedbackDAO;
import ssd.comedyvenue.model.Feedback;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackRepository implements Repository<Feedback> {

    private FeedbackDAO feedbackDAO;

    public void setFeedbackDAO(FeedbackDAO feedbackDAO){
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    @Transactional
    public void add(Feedback entity) {
        this.feedbackDAO.addFeedback(entity);
    }

    @Override
    @Transactional
    public void update(Feedback entity) {
        this.feedbackDAO.updateFeedback(entity);
    }

    @Override
    @Transactional
    public List<Feedback> list() {
        return this.feedbackDAO.listFeedback();
    }

    @Override
    @Transactional
    public Feedback getById(int id) {
        return this.feedbackDAO.getFeedbackById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.feedbackDAO.removeFeedback(id);
    }
}
