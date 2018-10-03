package com.example.feelsbook;

import java.io.Serializable;

// THE EMOTION CLASS THAT SETS AND GETS EMOTION PROPERTIES
public class Emotion implements Serializable{

    private String emotion;
    private String comment;
    private String date;

    Emotion(String emotion, String date, String comment) {
        this.emotion = emotion;
        this.date = date;
        this.comment = comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }
    public void setEmotion(String emotion){
        this.emotion = emotion;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getComment(){
        return this.comment;
    }
    public String getEmotion(){
        return this.emotion;
    }
    public String getDate(){
        return this.date;
    }

}
