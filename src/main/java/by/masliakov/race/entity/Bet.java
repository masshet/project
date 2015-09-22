package by.masliakov.race.entity;

/**
 * Created by mrstark on 21.9.15.
 */
public class Bet extends Entity {
    private int optionId;
    private int userId;
    private int valueOfBet;

    public Bet(){}

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getValueOfBet() {
        return valueOfBet;
    }

    public void setValueOfBet(int valueOfBet) {
        this.valueOfBet = valueOfBet;
    }
}
