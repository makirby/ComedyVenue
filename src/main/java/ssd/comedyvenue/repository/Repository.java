package ssd.comedyvenue.repository;

import java.util.List;

public interface Repository<T> {

    void add(T entity);
    void update(T entity);
    List<T> list();
    T getById(int id);
    void remove(int id);
}
