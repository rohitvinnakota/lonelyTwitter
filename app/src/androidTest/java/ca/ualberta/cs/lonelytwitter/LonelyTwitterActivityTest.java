package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }


    public void testAddTweet() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet1");
        //assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet2");
        tweets.add(tweet);
        NormalTweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet3");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("fffff");
        NormalTweet tweet2 = new NormalTweet("asdasd");
        tweet.setDate(new Date(12-12-2008));
        tweet2.setDate(new Date(12-12-2009));
        tweets.add(tweet2);
        tweets.add(tweet);
        ArrayList<NormalTweet> pp = new ArrayList<NormalTweet>();
        pp = tweets.getTweets();
        assertTrue(pp.get(0).getDate().compareTo(pp.get(1).getDate())<0);
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("sadasdasd");
        NormalTweet tweet2 = new NormalTweet("sadasdasd");
        tweets.add(tweet);
        tweets.add(tweet2);
        int x = tweets.getCount();
        assertEquals(x, 2);
    }
}