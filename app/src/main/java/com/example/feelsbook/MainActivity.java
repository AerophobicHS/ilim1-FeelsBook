package com.example.feelsbook;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

// PARENT ACTIVITY THAT DISPLAYS HOMEPAGE FUNCTIONALITY
public class MainActivity extends AppCompatActivity {

    // INITIALIZE
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    public static final int TEXT_REQUEST1 = 1;
    public static final int TEXT_REQUEST2 = 2;
    public TextView added_record;
    public ArrayList<Emotion> emotionArray = new ArrayList<>();
    public ArrayList<Emotion> updatedArray = new ArrayList<>();

    @Override
    // CREATES LAYOUT
    protected void onCreate(Bundle savedInstanceState) {

        // SUPER CLASS CALL
        super.onCreate(savedInstanceState);

        // SETS LAYOUT OF MAIN ACTIVITY
        setContentView(R.layout.activity_main);

    }

    @Override
    // SAVES STATE WHEN APP CLOSES
    public void onStart() {

        // SUPER CLASS CALL
        super.onStart();

        // CREATES INVISIBLE MESSAGE THAT SHOWS WHEN USER SUCCESSFULLY ADDS AN EMOTION
        added_record = findViewById(R.id.record_added);

    }

    @Override
    // RECEIVES RESULT FROM ACTIVITIES ADD COMMENT AND VIEW HISTORY
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // SUPER CLASS CALL
        super.onActivityResult(requestCode, resultCode, data);

        // DETECTS WHETHER ACTIVITY RESULT IS FROM ADD COMMENT OR VIEW HISTORY
        switch (requestCode) {

            // ADD COMMENT
            case TEXT_REQUEST1:

                // IF ACTIVITY RETURN SUCCESSFUL
                if(resultCode == RESULT_OK){

                    // GET THE RETURN FROM THE INTENT AND STORE IT AS AN EMOTION OBJECT
                    Emotion emotion = (Emotion) data.getSerializableExtra(AddComment.EXTRA_REPLY);

                    // ADD NEW EMOTION TO ARRAY
                    emotionArray.add(emotion);

                    // DISPLAY MESSAGE THAT EMOTION WAS SUCCESSFULLY ADDED
                    added_record.setVisibility(View.VISIBLE);

                }

                break;

            // VIEW HISTORY
            case TEXT_REQUEST2:

                // IF ACTIVITY RETURN SUCCESSFUL
                if(resultCode == RESULT_OK){

                    // MAKE NEW ARRAY AS THE ARRAY RETURNED FROM VIEW HISTORY
                    updatedArray = (ArrayList<Emotion>) data.getSerializableExtra(ViewHistory.EXTRA_MESSAGE);

                }

                // SET THE EMOTION ARRAY AS THE ACTIVITY ARRAY
                emotionArray = updatedArray;

                break;

            // DEFAULT CASE
            default:

                break;

        }

    }

    // CREATES INTENT TO AND SENDS DATA
    public void addComment(View view) {

        Button button = (Button) view;
        String buttonText = button.getText().toString();
        Intent intent = new Intent(this, AddComment.class);
        intent.putExtra(EXTRA_MESSAGE, buttonText);
        startActivityForResult(intent, TEXT_REQUEST1);

    }

    public void viewHistory(View view) {

        Intent historyIntent = new Intent(this, ViewHistory.class);
        historyIntent.putExtra(EXTRA_MESSAGE, emotionArray);
        startActivityForResult(historyIntent, TEXT_REQUEST2);

    }

    public void viewCount(View view){

        Intent countIntent = new Intent(this, ViewCount.class);
        countIntent.putExtra(EXTRA_MESSAGE, emotionArray);
        startActivity(countIntent);

    }

}