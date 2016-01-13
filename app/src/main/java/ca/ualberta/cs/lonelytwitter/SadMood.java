package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malba on 1/12/16.
 */
public class SadMood extends Mood implements Moody {

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String getMood() {
        return "I am in a SAD mood :(";
    }
}
