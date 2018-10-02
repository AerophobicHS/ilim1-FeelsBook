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


public class EmotionListAdapter extends ArrayAdapter<Emotion> {

    private Context eContext;
    int eResource;

    public EmotionListAdapter(Context context, int resource, ArrayList<Emotion> objects) {
        super(context, resource, objects);
        eContext = context;
        eResource = resource;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        String emotionName = getItem(position).getEmotion();
        String emotionDate = getItem(position).getDate();
        String emotionComment = getItem(position).getComment();
        Emotion emotion = new Emotion(emotionName, emotionDate, emotionComment);
        LayoutInflater inflater = LayoutInflater.from(eContext);
        convertView = inflater.inflate(eResource, parent, false);

        TextView eName = convertView.findViewById(R.id.emotionName);
        TextView eDate = convertView.findViewById(R.id.emotionDate);

        eName.setText(emotionName);
        eDate.setText(emotionDate);

        return convertView;
    }


}
