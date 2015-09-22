package by.masliakov.race.entity;

/**
 * Created by mrstark on 21.9.15.
 */
public class Horse extends Entity {
    private String name;

    public Horse() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
