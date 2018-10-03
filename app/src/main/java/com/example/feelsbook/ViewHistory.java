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
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        // GET EMOTION ARRAY FROM MAIN ACTIVITY
        emotions = (ArrayList<Emotion>) getIntent().getSerializableExtra(EXTRA_MESSAGE);
        ListView emotion_list = findViewById(R.id.emotionView);
        EmotionListAdapter adapter = new EmotionListAdapter(this, R.layout.adapter_view_layout, emotions);
        emotion_list.setAdapter(adapter);

        // EXECUTE WHEN AN ENTRY IN LIST VIEW IS CLICKED
        emotion_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                emotionPosition = position;
                Intent editIntent = new Intent(view.getContext(), EditComment.class);
                editIntent.putExtra(EXTRA_MESSAGE, emotions.get(emotionPosition));
                emotions.remove(emotionPosition);
                startActivityForResult(editIntent, TEXT_REQUEST2);

            }

        });

    }

    @Override
    // GETS EMOTION FROM EDIT COMMENT ACTIVITY AND UPDATES ARRAY
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST2){

            if(resultCode == RESULT_OK){

                // GET EMOTION FROM EDIT COMMENT
                Emotion emotion = (Emotion) data.getSerializableExtra(EditComment.EXTRA_MESSAGE);

                // IF EMOTION IS NOT EMPTY THEN ADD TO ARRAY AT OLD POSITION
                if (!"".equals(emotion.getEmotion())) {
                    emotions.add(emotionPosition, emotion);
                }

                // CREATE INTENT AND SEND TO MAIN ACTIVITY
                Intent updateIntent = new Intent();
                updateIntent.putExtra(EXTRA_MESSAGE, emotions);
                setResult(RESULT_OK, updateIntent);
                finish();

            }

        }

    }


}
