package ssd.comedyvenue.repository;

import org.springframework.transaction.annotation.Transactional;
import ssd.comedyvenue.dao.CustomerDAO;
import ssd.comedyvenue.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerRepository implements Repository<Customer> {

    private CustomerDAO customerDAO;

    public CustomerRepository(){}

    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void add(Customer entity) {
        this.customerDAO.addCustomer(entity);
    }

    @Override
    @Transactional
    public void update(Customer entity) {
        this.customerDAO.updateCustomer(entity);
    }

    @Override
    @Transactional
    public List<Customer> list() {
        return this.customerDAO.listCustomers();
    }

    @Override
    @Transactional
    public Customer getById(int id) {
        return this.customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.customerDAO.removeCustomer(id);
    }
}
