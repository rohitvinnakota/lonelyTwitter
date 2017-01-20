package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by vinnakot on 1/19/17.
 */

public abstract class CurrentMood { //cannot have an instance
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CurrentMood(){
        this.date = new Date();
    }

    public CurrentMood(Date date){
        this.date = date;
    }
    public abstract String moodRep();
}
