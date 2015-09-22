package by.masliakov.race.dao;

import by.masliakov.race.entity.Entity;

import java.util.ArrayList;

/**
 * Created by mrstark on 21.9.15.
 */
public abstract class AbstractDao <K, T extends Entity> {
    public abstract ArrayList<T> findAll();
    public abstract T findEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
}
