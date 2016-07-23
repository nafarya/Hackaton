package com.example.dan.hackaton.lang;

/**
 * Created by dan on 23.07.16.
 */
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.example.dan.hackaton.util.function.Consumer;

import java.util.ArrayList;
import java.util.List;

//import ru.yandex.yamblz.languagelearning.util.ContentLoader;
//import ru.yandex.yamblz.languagelearning.util.function.Consumer;

/**
 * Created by root on 7/23/16.
 */
public class Word {

    private final String word;
    private Language language;
    private List<Word> translates = new ArrayList<>();

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Word> getTranslates() {
        return translates;
    }

    public void setTranslates(List<Word> translates) {
        this.translates = translates;
    }

    public void setTranslate(Word word) {
        translates.add(word);
    }

    public Word getTranslate(Language language, Consumer<Word> callback) {
        for(Word translate : translates) {
            if(translate.getLanguage() == language) {
                return translate;
            }
        }

        if(callback == null) {
            return null;
        }

        if(WordStorage.get() != null) {

            Log.d("test", "request_translate");

            WordStorage.get().getContentLoader().translate(this, language, (word) -> callback.accept(word), (error) -> callback.accept(null));
        }
        return null;

    }

}
