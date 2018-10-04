package com.example.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// ADD COMMENT ACTIVITY THAT LETS USER INPUT A COMMENT WITH EMOTION ENTRY
public class AddComment extends AppCompatActivity{

    // INITIALIZE
    public static final String EXTRA_REPLY = "com.example.android.feelsbook.extra.REPLY";
    protected EditText comment;
    protected String emotionName;
    protected String strDate;
    protected String record;

    @Override
    // CREATES LAYOUT
    protected void onCreate(Bundle savedInstanceState){

        // SUPER CLASS CALL
        super.onCreate(savedInstanceState);

        // SETS LAYOUT FOR ADD COMMENT ACTIVITY
        setContentView(R.layout.activity_add_comment);

    }
    @Override
    // EXECUTE ON APP START
    public void onStart() {

        // SUPER CLASS CALL
        super.onStart();

        // RECEIVE INTENT FROM MAIN ACTIVITY
        Intent intent = getIntent();

        // GET STRING EMOTION FROM INTENT
        emotionName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // INITIALIZE TEXT VIEW FOR EMOTION NAME
        TextView textView = findViewById(R.id.text_emotion);

        // SET THE TEXT VIEW TO THE EMOTION NAME
        textView.setText(emotionName);

        // INITIALIZE CALENDAR
        Calendar calendar = Calendar.getInstance();

        // SET FORMAT OF DATE
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        // CREATE DATE FROM CURRENT TIME
        strDate = format.format(calendar.getTime());

        // INITIALIZE TEXT VIEW FOR EMOTION DATE
        TextView dateView = findViewById(R.id.record_date);

        // SET THE TEXT VIEW TO THE CURRENT DATE
        dateView.setText(strDate);

    }

    // RETURNS EMOTION RECORD TO MAIN ACTIVITY
    public void returnRecord(View view){

        // INITIALIZE COMMENT TEXT VIEW
        comment = findViewById(R.id.text_comment);

        // GET THE STRING OF THAT TEXT VIEW
        record = comment.getText().toString();

        // CREATE INSTANCE OF EMOTION
        Emotion emotion = new Emotion(emotionName, strDate, record);

        // CREATE AN INTENT TO SEND BACK TO MAIN ACTIVITY
        Intent recordIntent = new Intent();

        // PUT NEW EMOTION INTO INTENT
        recordIntent.putExtra(EXTRA_REPLY, emotion);

        // SEND INTENT
        setResult(RESULT_OK,recordIntent);

        // END ACTIVITY
        finish();

    }

}
