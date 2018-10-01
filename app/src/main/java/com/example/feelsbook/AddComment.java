package com.example.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddComment extends AppCompatActivity{

    public static final String EXTRA_REPLY = "com.example.android.feelsbook.extra.REPLY";
    protected EditText comment;
    protected String emotionName;
    protected String strDate;
    protected String record;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        Intent intent = getIntent();
        emotionName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_emotion);
        textView.setText(emotionName);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        strDate = format.format(calendar.getTime());
        TextView dateView = findViewById(R.id.record_date);
        dateView.setText(strDate);

    }

    public void returnRecord(View view){

        comment = findViewById(R.id.text_comment);
        record = comment.getText().toString();
        Emotion emotion = new Emotion(emotionName, strDate, record);
        Intent recordIntent = new Intent();
        recordIntent.putExtra(EXTRA_REPLY, emotion);
        setResult(RESULT_OK,recordIntent);
        finish();

    }

}
