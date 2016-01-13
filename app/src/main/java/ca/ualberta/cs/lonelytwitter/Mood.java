package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malba on 1/12/16.
 */
public abstract class Mood implements Moody {

    protected Date date;

    // all child classes must implement this method
    public abstract String getMood();

    // constructor when no date is provided (uses current time)
    public Mood() {
        this.date = new Date();
    }

    // constructor when a date is provided
    public Mood(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
