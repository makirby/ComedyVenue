package ssd.comedyvenue.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ssd.comedyvenue.model.Comedian;

import java.util.List;

@Repository
public class ComedianDAOImpl implements ComedianDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComedian(Comedian comedian) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(comedian);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateComedian(Comedian comedian) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(comedian);
    }

    @Override
    public List<Comedian> listComedians() {
        Session session = this.sessionFactory.openSession();
        List<Comedian> comedianList = session.createQuery("from Comedian").list();
        session.close();
        return comedianList;
    }

    @Override
    public Comedian getComedianById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Comedian comedian = (Comedian) session.load(Comedian.class, new Integer(id));
        return comedian;
    }

    @Override
    public void removeComedian(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Comedian comedian = (Comedian) session.load(Comedian.class, new Integer(id));
        if(null != comedian){
            session.delete(comedian);
        }
    }
}