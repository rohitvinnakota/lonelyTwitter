package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        Intent intent = getIntent();
        String x = intent.getStringExtra("oo");
        TextView textview = (TextView)findViewById(R.id.textView);
        textview.setText(x);

    }
    public String returnX(){
        return "Test Tweet!";
    }


}
