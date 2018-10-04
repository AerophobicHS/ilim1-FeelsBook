package com.example.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewHistory extends AppCompatActivity {

    // INITIALIZE
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    public static final int TEXT_REQUEST2 = 2;
    public int emotionPosition;
    public ArrayList<Emotion> emotions;

    @Override
    // CREATES LAYOUT
    protected void onCreate(Bundle savedInstanceState) {

        // SUPER CLASS CALL
        super.onCreate(savedInstanceState);

        // SETS LAYOUT OF MAIN ACTIVITY
        setContentView(R.layout.activity_view_history);

    }

    @Override
    // EXECUTE ON APP START
    public void onStart() {

        // SUPER CLASS CALL
        super.onStart();

        // GET EMOTION ARRAY FROM MAIN ACTIVITY
        emotions = (ArrayList<Emotion>) getIntent().getSerializableExtra(EXTRA_MESSAGE);

        // GET LIST VIEW ELEMENT
        ListView emotion_list = findViewById(R.id.emotionView);

        // CREATE INSTANCE OF CUSTOM ADAPTER
        EmotionListAdapter adapter = new EmotionListAdapter(this, R.layout.adapter_view_layout, emotions);

        // SET ADAPTER FOR LIST VIEW
        emotion_list.setAdapter(adapter);

        // EXECUTE WHEN AN ENTRY IN LIST VIEW IS CLICKED
        emotion_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            // CREATE INTENT ON EMOTION CLICK
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // SET
                emotionPosition = position;

                // CREATE AN INTENT TO EDIT COMMENT ACTIVITY
                Intent editIntent = new Intent(view.getContext(), EditComment.class);

                // PUT EMOTION POSITION INTO INTENT
                editIntent.putExtra(EXTRA_MESSAGE, emotions.get(emotionPosition));

                // START ACTIVITY
                startActivityForResult(editIntent, TEXT_REQUEST2);

            }

        });

    }

    @Override
    // GETS EMOTION FROM EDIT COMMENT ACTIVITY AND UPDATES ARRAY
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // SUPER CLASS CALL
        super.onActivityResult(requestCode, resultCode, data);

        // // VIEW HISTORY
        if(requestCode == TEXT_REQUEST2){

            // IF ACTIVITY RETURN SUCCESSFUL
            if(resultCode == RESULT_OK){

                // REMOVE OLD EMOTION
                emotions.remove(emotionPosition);

                // GET EMOTION FROM EDIT COMMENT
                Emotion emotion = (Emotion) data.getSerializableExtra(EditComment.EXTRA_MESSAGE);

                // IF EMOTION NAME IS NOT EMPTY
                if (!"".equals(emotion.getEmotion())) {

                    // ADD EMOTION
                    emotions.add(emotionPosition, emotion);

                }

                // CREATE INTENT AND SEND TO MAIN ACTIVITY
                Intent updateIntent = new Intent();

                // PUT EMOTIONS ARRAY INTO INTENT
                updateIntent.putExtra(EXTRA_MESSAGE, emotions);

                // SEND INTENT
                setResult(RESULT_OK, updateIntent);

                // END ACTIVITY
                finish();

            }

        }

    }

}
