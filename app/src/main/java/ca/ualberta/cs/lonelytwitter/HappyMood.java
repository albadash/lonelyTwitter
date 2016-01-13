package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malba on 1/12/16.
 */
public class HappyMood extends Mood implements Moody {

    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String getMood() {
        return "I am in a HAPPY mood :)";
    }
}
