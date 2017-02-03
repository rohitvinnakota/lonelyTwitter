package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class implements one of two different kinds of tweets. The important tweet.
 * @see #isImportant()
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    /**
     * @return True for the variable isImportant since this is an important tweet
     */
    public Boolean isImportant(){
        return true;
    }
}