/*
 * Copyright (c) 2017. Cmput 391, University Of Alberta. All rights Reserved. You may not use..
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vinnakot on 2/16/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet) {
        if(hasTweet(tweet)==true){
            throw new IllegalArgumentException("Tweet exists");
        }
        else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(NormalTweet tweet) {
        return tweets.contains(tweet);
    }

    public NormalTweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<NormalTweet> getTweets(){
//http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        Collections.sort(tweets, new Comparator<NormalTweet>() {
            public int compare(NormalTweet o1, NormalTweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return tweets;
    }


    public void delete(NormalTweet tweet) {
        tweets.remove(tweet);
    }


    public int getCount(){
        return tweets.size();
    }
}








