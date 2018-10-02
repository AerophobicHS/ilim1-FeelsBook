package com.example.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.feelsbook.AddComment.EXTRA_REPLY;


public class EditComment extends AppCompatActivity {

    // INITIALIZE
    public static final String EXTRA_MESSAGE = "com.example.android.feelsbook.extra.MESSAGE";
    protected TextView editEmotion;
    protected EditText editDate;
    protected EditText editComment;
    protected String newEmotion;
    protected String newDate;
    protected String newComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_comment);

        // GET SELECTED EMOTION FROM HISTORY ACTIVITY
        Emotion emotion = (Emotion) getIntent().getSerializableExtra(EXTRA_MESSAGE);

        // SETTING THE LAYOUT ELEMENTS WITH EMOTION DATA
        TextView emotionName = findViewById(R.id.text_emotion);
        emotionName.setText(emotion.getEmotion());
        EditText emotionDate = findViewById(R.id.record_date);
        emotionDate.setText(emotion.getDate());
        EditText emotionComment = findViewById(R.id.text_comment);
        emotionComment.setText(emotion.getComment());

    }

    // RETURNS EDITED EMOTION DATA
    public void returnEmotion(View view){

        // GETTING UPDATED EMOTION, DATE, AND COMMENT FROM LAYOUT
        editEmotion = findViewById(R.id.text_emotion);
        newEmotion = editEmotion.getText().toString();
        editDate = findViewById(R.id.record_date);
        newDate = editDate.getText().toString();
        editComment = findViewById(R.id.text_comment);
        newComment = editComment.getText().toString();

        // CREATE EMOTION WITH UPDATED VALUES
        Emotion emotion = new Emotion(newEmotion, newDate, newComment);

        // CREATE INTENT AND SEND TO VIEW HISTORY
        Intent updateIntent = new Intent();
        updateIntent.putExtra(EXTRA_MESSAGE, emotion);
        setResult(RESULT_OK, updateIntent);
        finish();

    }

    // RETURNS INDICATOR TO DELETE EMOTION IN VIEW HISTORY ACTIVITY
    public void deleteEmotion(View view){

        // CREATE EMOTION WITH UPDATED VALUES
        Emotion emotion = new Emotion("", "", "");

        // CREATE INTENT AND SEND TO VIEW HISTORY
        Intent deleteIntent = new Intent();
        deleteIntent.putExtra(EXTRA_MESSAGE, emotion);
        setResult(RESULT_OK, deleteIntent);
        finish();

    }

}
