package com.example.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewHistory extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        ArrayList<Emotion> emotions;
        emotions = (ArrayList<Emotion>) getIntent().getSerializableExtra(EXTRA_MESSAGE);
        ListView emotion_list = findViewById(R.id.emotionView);
        EmotionListAdapter adapter = new EmotionListAdapter(this, R.layout.adapter_view_layout, emotions);
        emotion_list.setAdapter(adapter);
    }

}
