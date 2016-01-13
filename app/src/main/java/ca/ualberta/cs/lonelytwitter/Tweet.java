package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malba on 1/12/16.
 */
public abstract class Tweet implements Tweetable {

    protected Date date;
    protected String message;

    // all child classes must implement the following
    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
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
}
