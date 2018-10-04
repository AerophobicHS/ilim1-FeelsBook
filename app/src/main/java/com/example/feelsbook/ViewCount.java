package com.example.feelsbook;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

// DISPLAYS PAGE THAT ADDS COUNT OF EACH EMOTION IN ARRAY
public class ViewCount extends AppCompatActivity{

    // INITIALIZE
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    int love, joy, surprise, anger, sadness, fear;

    @Override
    // CREATES LAYOUT
    protected void onCreate(Bundle savedInstanceState) {

        // SUPER CLASS CALL
        super.onCreate(savedInstanceState);

        // SET LAYOUT FOR VIEW COUNT ACTIVITY
        setContentView(R.layout.activity_view_count);

    }

    @SuppressLint("SetTextI18n")
    @Override
    // EXECUTE ON APP START
    public void onStart() {

        // SUPER CLASS CALL
        super.onStart();

        // INITIALIZE ARRAY LIST OF EMOTIONS
        ArrayList<Emotion> emotions;

        // SET TO ARRAY LIST FROM MAIN ACTIVITY
        emotions = (ArrayList<Emotion>) getIntent().getSerializableExtra(EXTRA_MESSAGE);

        // IF SIZE OF THE EMOTION ARRAY IS ZERO
        if(emotions.size() == 0){

            // SET COUNTS AS 0
            love = joy = surprise = anger = sadness = fear = 0;

        // SCAN ARRAY
        }else{

            // FOR EACH EMOTION IN ARRAY
            for (int i = 0; i < emotions.size(); i++) {

                // GET THE STRING EMOTION NAME
                String emotion = emotions.get(i).getEmotion();

                // SWITCH ON THE EMOTION NAME
                switch(emotion){

                    case "Love":
                        love++;
                        break;

                    case "Joy":
                        joy++;
                        break;

                    case "Surprise":
                        surprise++;
                        break;

                    case "Anger":
                        anger++;
                        break;

                    case "Sadness":
                        sadness++;
                        break;

                    case "Fear":
                        fear++;
                        break;

                    default:
                        break;

                }

            }

        }

        // SETTING THE TEXT VIEWS OF VIEW COUNT TO THE EMOTION COUNTS
        TextView love_count = findViewById(R.id.count_love);
        love_count.setText(Integer.toString(love));
        TextView joy_count = findViewById(R.id.count_joy);
        joy_count.setText(Integer.toString(joy));
        TextView surprise_count = findViewById(R.id.count_surprise);
        surprise_count.setText(Integer.toString(surprise));
        TextView anger_count = findViewById(R.id.count_anger);
        anger_count.setText(Integer.toString(anger));
        TextView sadness_count = findViewById(R.id.count_sadness);
        sadness_count.setText(Integer.toString(sadness));
        TextView fear_count = findViewById(R.id.count_fear);
        fear_count.setText(Integer.toString(fear));

    }

}
