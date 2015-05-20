package ssd.comedyvenue.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import ssd.comedyvenue.model.Comedian;
import ssd.comedyvenue.util.ConnectionProvider;

import java.sql.SQLException;
import java.util.List;

public class ComedianRepository implements Repository<Comedian> {

    Dao<Comedian, Integer> comedianDao;

    public ComedianRepository(){

        try {
            this.comedianDao = DaoManager.createDao(ConnectionProvider.getConnection(), Comedian.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Comedian entity){

        try {
            this.comedianDao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Comedian entity){

        try {
            this.comedianDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comedian> list(){

        try {
            return this.comedianDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Comedian getById(int id){
        try {
            return this.comedianDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(int id){

        try {
            this.comedianDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
