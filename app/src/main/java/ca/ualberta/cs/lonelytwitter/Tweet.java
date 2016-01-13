package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by malba on 1/12/16.
 */
public abstract class Tweet implements Tweetable {

    protected Date date;
    protected String message;
    protected ArrayList<Mood> moods;

    // all child classes must implement the following
    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException {

        // restrict message length
        if (message.length() > 140) throw new TweetTooLongException();

        // set message
        this.message = message;
    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }
}
