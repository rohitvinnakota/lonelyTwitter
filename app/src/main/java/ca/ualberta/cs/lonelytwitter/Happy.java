package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by vinnakot on 1/19/17.
 */

public class Happy extends CurrentMood {
    public Happy(Date date) {
        super(date);
    }
    public Happy() {
        super();
    }

    public String moodRep(){
        return("Happy!");
    }
}
