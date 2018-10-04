package com.example.feelsbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// CUSTOM ADAPTER CLASS THAT DISPLAYS EMOTION ARRAY INSIDE LIST VIEW
public class EmotionListAdapter extends ArrayAdapter<Emotion> {

    // INITIALIZE
    private Context eContext;
    int eResource;

    // CONSTRUCTOR
    EmotionListAdapter(Context context, int resource, ArrayList<Emotion> objects) {
        super(context, resource, objects);
        eContext = context;
        eResource = resource;

    }
    @NonNull
    @Override
    // SETTING EACH ELEMENT OF THE LIST VIEW TO EMOTION DATA
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        // GET EMOTION DATA FROM ARRAY
        String emotionName = getItem(position).getEmotion();
        String emotionDate = getItem(position).getDate();

        // CREATE INFLATER FOR LAYOUT
        LayoutInflater inflater = LayoutInflater.from(eContext);

        // CREATE VIEW
        convertView = inflater.inflate(eResource, parent, false);

        // INITIALIZE TEXT VIEWS IN LIST VIEW ELEMENTS
        TextView eName = convertView.findViewById(R.id.emotionName);
        TextView eDate = convertView.findViewById(R.id.emotionDate);

        // SET TEXT VIEWS TO EMOTION DATA
        eName.setText(emotionName);
        eDate.setText(emotionDate);

        // RETURN
        return convertView;

    }

}
