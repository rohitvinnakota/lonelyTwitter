package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;

/**
 * This implements the abstract tweetable interface. It provides the following functions
 * <ul>
 *     <li>Getters and setters for the date</li>
 *     <li>Getters and setters for the message</li>
 *     <li>To string to create the method to a string</li>
 *     <li>isImportant to determine if the tweet is important</li>
 * </ul>
 *
 *
 * @author vinnakot
 * @version 1.4.2
 * @since 1.0
 */

public abstract class Tweet implements Tweetable{
    /**
     * Abstract class implements functions to modify and change tweets
     *
     */
    private Date date;
    private String message;
    private ArrayList listofmoods;


    public ArrayList getListofmoods() {
        return listofmoods;
    }


    /**
     * Sets mood to happy or sad
     * @param listofmoods
     */
    public void setListofmoods(ArrayList listofmoods) {
        this.listofmoods = listofmoods;
    }




    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(Date date, String message){
        this.message = message;
        this.date = date;
    }

    /**
     * getter for date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for date that sets the date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Getter for the message string
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for the message string
     * @param message
     * @throws TweetTooLongException
     * @exception TweetTooLongException if the tweet is too long
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public abstract Boolean isImportant();

    @Override
    /**
     * Converts a date to string and adds the message
     * @return date as a string
     */
    public String toString(){
        return date.toString() + " | " + message;

    }



}
