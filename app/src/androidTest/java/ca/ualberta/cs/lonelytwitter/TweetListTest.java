package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by malba on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try {
            tweets.addTweet(tweet);
            Assert.fail("Should have thrown InvalidArgumentException.");
        } catch (IllegalArgumentException e) {
            // everything is peaches and cream!
        }
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        ArrayList<Tweet> returnedTweets = tweets.getTweets();
        assertTrue(returnedTweets.isEmpty());

        Tweet tweet;
        int threshold = 50;

        // add a bunch of tweets
        for (int i = 0; i < threshold; i++) {
            tweet = new NormalTweet("hello" + i);
            tweets.addTweet(tweet);
        }

        // get tweets and make sure everything is there and in order
        returnedTweets = tweets.getTweets();
        for (int j = 0; j < threshold; j++) {
            assertTrue(returnedTweets.contains(tweets.getTweet(j)));
            if (j != threshold - 1) {
                assertTrue(returnedTweets.get(j).getDate().compareTo(returnedTweets.get(j + 1).getDate()) <= 0);
            }
        }

        // clear all that and try testing dates not in order
        tweets = new TweetList();
        Date earlier_date = new Date();
        tweet = new NormalTweet(new Date(), "hello");
        tweets.addTweet(tweet);
        tweet = new NormalTweet(earlier_date, "hello");
        tweets.addTweet(tweet);
        returnedTweets = tweets.getTweets();
        assertTrue(returnedTweets.get(0).getDate().compareTo(returnedTweets.get(1).getDate()) <= 0);
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        tweets.hasTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(tweet.getMessage(), returnedTweet.getMessage());
        assertEquals(tweet.getDate(), returnedTweet.getDate());
    }

    public void testRemoveTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.removeTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet;
        int threshold = 50;

        for (int i = 0; i < threshold; i++) {
            assertEquals(tweets.getCount(), i);
            tweet = new NormalTweet("test"+i);
            tweets.addTweet(tweet);
        }
    }
}
