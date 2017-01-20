package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by vinnakot on 1/19/17.
 */

public class Sad extends CurrentMood {

    public Sad(Date date) {
        super(date);
    }
    public Sad() {
        super();
    }

    public String moodRep(){
        return("Sad!");
    }
}
