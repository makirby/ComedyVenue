package ssd.comedyvenue.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ssd.comedyvenue.model.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public List<Customer> listCustomers() {
        Session session = this.sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        session.close();
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        return customer;
    }

    @Override
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        if(null != customer){
            session.delete(customer);
        }
    }
}
