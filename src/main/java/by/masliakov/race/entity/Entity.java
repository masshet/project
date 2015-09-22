package by.masliakov.race.entity;

import java.io.Serializable;

/**
 * Created by mrstark on 21.9.15.
 */
public abstract class Entity implements Serializable, Cloneable {
    private int id;

    public Entity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
