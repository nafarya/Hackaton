package com.example.dan.hackaton.lang;

/**
 * Created by dan on 23.07.16.
 */

import android.content.Context;
import android.util.Log;

import com.example.dan.hackaton.util.ContentLoader;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by root on 7/23/16.
 */
public class WordStorage {

    private Context context;
    private ContentLoader contentLoader;

    private Map<Language, List<Word>> localStorage = new HashMap<>();

    private static WordStorage instance;

    private WordStorage(Context context) {
        this.context = context.getApplicationContext();
        contentLoader = new ContentLoader(this.context);
        initializeLocalStorage();
    }

    private void initializeLocalStorage() {
        File folder = new File(context.getFilesDir() + "/words");
        if(!folder.exists()) {
            folder.mkdir();
        }

        File enWords = new File(folder.getPath() + "/EN");
        File ruWords = new File(folder.getPath() + "/RU");

        if(!enWords.exists()) {
            try {
                enWords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fillEnglish(enWords);
        }

        if(!ruWords.exists()) {
            try {
                ruWords.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fillRussian(ruWords);
        }

        readWords(enWords);
        readWords(ruWords);

    }

    private void fillEnglish(File enWords) {
        fillWords(enWords, new String[] {
                "shock",
                "start",
                "mind",
                "cloth",
                "sleep",
                "land",
                "belief",
                "behavior",
                "sugar",
                "history",
                "hate",
                "offer",
                "pain",
                "ice",
                "thought",
                "secretary",
                "swim",
                "society",
                "soap",
                "music",
                "month",
                "trouble",
                "front",
                "use",
                "liquid",
                "wood",
                "night",
                "brother",
                "answer",
                "name",
                "soup",
                "insurance",
                "journey",
                "attack",
                "disease",
                "surprise",
                "run",
                "smile",
                "price",
                "weather",
                "oil",
                "stop",
                "government",
                "art",
                "chance",
                "jump",
                "meal",
                "discussion",
                "suggestion",
                "play",
                "building",
                "move",
                "blood",
                "reaction",
                "rain",
                "payment",
                "mist",
                "money",
                "waste",
                "company",
                "sand",
                "milk",
                "machine",
                "lead",
                "push",
                "peace",
                "family",
                "teaching",
                "organization",
                "doubt",
                "fall",
                "glass",
                "damage",
                "friend",
                "news",
                "slip",
                "wine",
                "power",
                "flight",
                "detail",
                "sense",
                "feeling",
                "memory",
                "opinion",
                "story",
                "change",
                "man",
                "credit",
                "space",
                "number",
                "song",
                "punishment",
                "letter",
                "connection",
                "produce",
                "road",
                "rest",
                "pull",
                "shake",
                "country"
        });
    }


    private void fillRussian(File ruWords) {
        fillWords(ruWords, new String[] {
                "опять",
                "ещё",
                "он",
                "сделать",
                "вы",
                "белый",
                "получить",
                "нужный",
                "думать",
                "очень",
                "чёрный",
                "знать",
                "вдруг",
                "иметь",
                "совсем",
                "разный",
                "страна",
                "место",
                "жизнь",
                "понять",
                "главный",
                "нужно",
                "я",
                "сидеть",
                "делать",
                "далёкий",
                "дом",
                "лицо",
                "работа",
                "полный",
                "можно",
                "ребенок",
                "хороший",
                "тоже",
                "вид",
                "понимать",
                "друг",
                "такой",
                "мир",
                "сила",
                "его",
                "почти",
                "идти",
                "советский",
                "также",
                "сегодня",
                "слово",
                "лучший",
                "стать",
                "вопрос",
                "молодой",
                "сразу",
                "пойти",
                "этот",
                "сам",
                "например",
                "вообще",
                "видеть",
                "то",
                "оказаться",
                "основной",
                "они",
                "глаз",
                "как",
                "мы",
                "быть",
                "спросить",
                "настоящий",
                "раз",
                "рука",
                "особенно",
                "говорить",
                "она",
                "уже",
                "хотеть",
                "один",
                "русский",
                "сторона",
                "себя",
                "наш",
                "новый",
                "нет",
                "хорошо",
                "голова",
                "дела",
                "ты",
                "работать",
                "старый",
                "большой",
                "дать",
                "мочь",
                "бить",
                "свой",
                "последний",
                "маленький",
                "смотреть",
                "вместе",
                "день",
                "взять",
                "надо"
        });
    }

    private void fillWords(File wordsFile, String[] words) {

        StringBuilder concatWords = new StringBuilder();

        for(String word : words) {
            concatWords.append(word);
            concatWords.append("\n");
        }

        try {
            IOUtils.write(concatWords.toString(), new FileOutputStream(wordsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readWords(File words) {

        Language language = Language.valueOf(words.getName());

        List<Word> list = new ArrayList<>();

        String fileContent = null;
        try {
            fileContent = IOUtils.toString(new FileInputStream(words));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String word : fileContent.split("\n")) {
            list.add(new Word(word, language));
        }

        localStorage.put(language, list);

    }

    public static void init(Context context) {
        if(instance == null) {
            instance = new WordStorage(context);
        }
    }

    public List<Word> getLocalWords(Language language) {
        Log.i("azaa", " " + localStorage.get(language).size());
        return localStorage.get(language);
    }

    public static WordStorage get() {
        return instance;
    }

    public ContentLoader getContentLoader() {
        return contentLoader;
    }
}