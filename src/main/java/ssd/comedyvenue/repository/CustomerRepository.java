package ssd.comedyvenue.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import ssd.comedyvenue.model.Customer;
import ssd.comedyvenue.util.ConnectionProvider;

import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {

    Dao<Customer, Integer> customerDao;

    public CustomerRepository(){

        try {
            this.customerDao = DaoManager.createDao(ConnectionProvider.getConnection(), Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Customer entity){

        try {
            this.customerDao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Customer entity){

        try {
            this.customerDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> list(){

        try {
            return this.customerDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer getById(int id){

        try {
            return this.customerDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(int id){

        try {
            this.customerDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
