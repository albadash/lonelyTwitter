package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by malba on 1/26/16.
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets() {

        TweetList sortedTweets = new TweetList();
        sortedTweets.tweets.addAll(tweets);

        // here's where I should be sorting this damn list
        //Collection.sort(sortedTweets.tweets);

        return sortedTweets.tweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }
}
