package ssd.comedyvenue.dao;

import org.hibernate.SessionFactory;
import ssd.comedyvenue.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void setSessionFactory(SessionFactory sessionFactory);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    List<Customer> listCustomers();

    Customer getCustomerById(int id);

    void removeCustomer(int id);
}
