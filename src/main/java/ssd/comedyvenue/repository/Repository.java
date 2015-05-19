package ssd.comedyvenue.repository;

import java.util.List;

public interface Repository<T> {

    public void add(T entity);
    public void update(T entity);
    public List<T> list();
    public T getById(int id);
    public void remove(int id);
}
