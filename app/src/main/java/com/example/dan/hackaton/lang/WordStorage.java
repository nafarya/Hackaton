package com.example.dan.hackaton.lang;

/**
 * Created by dan on 23.07.16.
 */
import android.content.Context;

import com.example.dan.hackaton.util.ContentLoader;

//import ru.yandex.yamblz.languagelearning.util.ContentLoader;


/**
 * Created by root on 7/23/16.
 */
public class WordStorage {

    private Context context;
    private ContentLoader contentLoader;

    private static WordStorage instance;

    private WordStorage(Context context) {
        this.context = context.getApplicationContext();
        contentLoader = new ContentLoader(this.context);
    }

    public static void init(Context context) {
        if(instance == null) {
            instance = new WordStorage(context);
        }
    }

    public static WordStorage get() {
        return instance;
    }

    public ContentLoader getContentLoader() {
        return contentLoader;
    }
}