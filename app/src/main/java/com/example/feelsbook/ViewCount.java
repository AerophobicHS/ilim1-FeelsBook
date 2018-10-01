package com.example.feelsbook;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;

public class ViewCount extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    private static final String LOG_TAG = ViewCount.class.getSimpleName();
    int love, joy, surprise, anger, sadness, fear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_count);

    }

    @Override
    public void onStart() {
        super.onStart();
        ArrayList<Emotion> emotions;
        emotions = (ArrayList<Emotion>) getIntent().getSerializableExtra(EXTRA_MESSAGE);
        if(emotions.size() == 0){

            love = joy = surprise = anger = sadness = fear = 0;

        }else{

            for (int i = 0; i < emotions.size(); i++) {

                String emotion = emotions.get(i).getEmotion();

                switch (emotion) {
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
