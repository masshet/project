package by.masliakov.race.entity;

/**
 * Created by mrstark on 21.9.15.
 */
public class OptionRate extends Entity {
    private int horseId;
    private int raceId;
    private int winRate;

    public OptionRate() {
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public int getHorseId() {
        return horseId;
    }

    public int getRaceId() {
        return raceId;
    }

    public int getWinRate() {
        return winRate;
    }
}
