package com.example.dan.hackaton.util;

/**
 * Created by dan on 23.07.16.
 */
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dan.hackaton.lang.Language;
import com.example.dan.hackaton.lang.Word;
import com.example.dan.hackaton.util.function.Consumer;


/**
 * Created by root on 7/23/16.
 */
public class ContentLoader {

    private Context context;

    public ContentLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    private static final String API_KEY = "trnsl.1.1.20160723T103517Z.f6d977dd1ae3f49b.e4e9c8f5cbf9cd01f0b469e3c89a18902c0bbc01";

    public void translate(Word word, Language toLang, final Consumer<Word> successCallback, final Consumer<VolleyError> failCallback) {

        String url = makeLink(word.getWord(), word.getLanguage(), toLang);

        Log.d("test", "url: " + url);

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, (response) ->
                new ParseTask((parsedWord) -> successCallback.accept(parsedWord)).execute(response, toLang.name()), (error) -> Log.d("test", error.toString()));

        requestQueue.add(stringRequest);
        requestQueue.start();
    }

    private String makeLink(String text, Language from, Language to) {
        return new Uri.Builder().scheme("https")
                .authority("translate.yandex.net")
                .appendPath("api")
                .appendPath("v1.5")
                .appendPath("tr.json")
                .appendPath("translate")
                .appendQueryParameter("key", API_KEY)
                .appendQueryParameter("lang", ((from != null) ? from.name() + "-" : "") + to.name())
                .appendQueryParameter("text", text)
                .build().toString();
    }
}
