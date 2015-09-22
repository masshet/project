package by.masliakov.race.entity;

/**
 * Created by mrstark on 21.9.15.
 */
public class Race extends Entity {
    private int horseIdOne;
    private int horseIdTwo;
    private int horseIdTree;
    private int horseIdFour;
    private int horseIdFive;

    public Race() {}

    public int getHorseIdOne() {
        return horseIdOne;
    }

    public void setHorseIdOne(int horseIdOne) {
        this.horseIdOne = horseIdOne;
    }

    public int getHorseIdTwo() {
        return horseIdTwo;
    }

    public void setHorseIdTwo(int horseIdTwo) {
        this.horseIdTwo = horseIdTwo;
    }

    public int getHorseIdTree() {
        return horseIdTree;
    }

    public void setHorseIdTree(int horseIdTree) {
        this.horseIdTree = horseIdTree;
    }

    public int getHorseIdFour() {
        return horseIdFour;
    }

    public void setHorseIdFour(int horseIdFour) {
        this.horseIdFour = horseIdFour;
    }

    public int getHorseIdFive() {
        return horseIdFive;
    }

    public void setHorseIdFive(int horseIdFive) {
        this.horseIdFive = horseIdFive;
    }
}
