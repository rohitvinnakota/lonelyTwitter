package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class implements one of two different kinds of tweets. The normal tweet.
 * @see #isImportant()
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    /**
     * @return False for the variable isImportant since this is not an important tweet
     */
    public Boolean isImportant(){
        return false;
    }
}
