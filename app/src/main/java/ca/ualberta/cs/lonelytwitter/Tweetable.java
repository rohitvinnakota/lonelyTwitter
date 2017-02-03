package ca.ualberta.cs.lonelytwitter;

/**
 * Tweetable interface to throw TweetTooLongException and create a getMessage object.
 *
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}