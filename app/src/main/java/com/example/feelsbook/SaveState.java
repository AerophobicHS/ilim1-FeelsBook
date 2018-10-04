package com.example.feelsbook;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

// LOADS AND SAVES APP STATE
public class SaveState{

    private static final String FILENAME = "file.sav";
    private Context myContext;

    public SaveState(Context saveContext){

        this.myContext = saveContext;

    }

    protected ArrayList<Emotion> loadFromFile() {
        ArrayList<Emotion> arr = new ArrayList<>();

        try {
            FileInputStream fis = myContext.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Emotion>>(){}.getType();
            arr = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    return arr;

    }

    protected void saveInFile(ArrayList<Emotion> arr) {
        try {
            FileOutputStream fos = myContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(arr, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO: Handle the Exception properly later
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
