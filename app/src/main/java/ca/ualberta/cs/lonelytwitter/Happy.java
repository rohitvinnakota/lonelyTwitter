package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is an extension of CurrentMood. Provides a happy object with a date
 * @see #CurrentMood
 */

public class Happy extends CurrentMood {
    public Happy(Date date) {
        super(date);
    }
    public Happy() {
        super();
    }

    /**
     * Returns a string showcasing the mood
     * @return string saying Happy!
     */
    public String moodRep(){
        return("Happy!");
    }
}
