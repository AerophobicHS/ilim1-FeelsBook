package com.example.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    public TextView added_record;
    public ArrayList<Emotion> emotionArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        added_record = findViewById(R.id.record_added);

    }

    @Override
    // GETS EMOTION FROM ADD COMMENT ACTIVITY AND ADDS TO ARRAY
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){

            if(resultCode == RESULT_OK){

                Emotion emotion = (Emotion) data.getSerializableExtra(AddComment.EXTRA_REPLY);
                emotionArray.add(emotion);
                added_record.setVisibility(View.VISIBLE);
                // Log.d(LOG_TAG, emotion.getComment());

            }

        }

    }

    public void addComment(View view){

        Button button = (Button) view;
        String buttonText = button.getText().toString();
        Intent intent = new Intent(this, AddComment.class);
        intent.putExtra(EXTRA_MESSAGE, buttonText);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    public void viewHistory(View view){

        Intent historyIntent = new Intent(this, ViewHistory.class);
        historyIntent.putExtra(EXTRA_MESSAGE, emotionArray);
        startActivity(historyIntent);

    }

    public void viewCount(View view){

        Intent countIntent = new Intent(this, ViewCount.class);
        countIntent.putExtra(EXTRA_MESSAGE, emotionArray);
        startActivity(countIntent);

    }

}
