package com.example.dan.hackaton.util;

/**
 * Created by dan on 23.07.16.
 */
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.WorkSource;
import android.util.Log;

import com.example.dan.hackaton.lang.Language;
import com.example.dan.hackaton.lang.Word;
import com.example.dan.hackaton.lang.WordResponse;
import com.example.dan.hackaton.util.function.Consumer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;



/**
 * Created by root on 7/23/16.
 */
public class ParseTask extends AsyncTask<String, Void, Word> {

    private Consumer<Word> consumer;

    public ParseTask(Consumer<Word> consumer) {

        this.consumer = consumer;
    }

    @Override
    protected Word doInBackground(String... strings) {

        Log.d("test", "here");
        Log.d("test", strings[0]);

        WordResponse wordResponse = new Gson().fromJson(strings[0], WordResponse.class);

        Log.d("test", wordResponse.getText()[0]);
        Log.d("test", strings[1]);


        Word word = new Word(wordResponse.getText()[0]);
        word.setLanguage(Language.valueOf(strings[1]));

        return word;
    }

    @Override
    protected void onPostExecute(Word word) {
        consumer.accept(word);
    }
}