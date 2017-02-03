package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is an extension of CurrentMood. Provides a sad object with a date
 * @see #CurrentMood
 */

public class Sad extends CurrentMood {

    public Sad(Date date) {
        super(date);
    }
    public Sad() {
        super();
    }

    /**
     * Returns a string showcasing the mood
     * @return string saying Sad!
     */
    public String moodRep(){
        return("Sad!");
    }
}
