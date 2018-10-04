package com.example.feelsbook;

import java.io.Serializable;

// THE EMOTION CLASS THAT SETS AND GETS EMOTION PROPERTIES
public class Emotion implements Serializable{

    // INITIALIZE
    private String emotion;
    private String comment;
    private String date;

    // CONSTRUCTOR
    Emotion(String emotion, String date, String comment) {

        // SET
        this.emotion = emotion;
        this.date = date;
        this.comment = comment;

    }

    // SETTER AND GETTER METHODS
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
