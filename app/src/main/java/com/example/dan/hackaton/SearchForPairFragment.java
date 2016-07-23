package com.example.dan.hackaton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dan.hackaton.lang.Language;
import com.example.dan.hackaton.lang.Word;
import com.example.dan.hackaton.lang.WordStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by dan on 23.07.16.
 */
public class SearchForPairFragment extends BaseFragment {

    Button[] buttonListLeft, buttonListRight;

    Map<Word, Word> map = new HashMap<>();
    List<Word> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_for_pair_fragment, container, false);

        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();


        Collections.shuffle(WordStorage.get().getLocalWords(Language.EN));
        for (int i = 0; i < 6; i++) {
            Word tmp = WordStorage.get().getLocalWords(Language.EN).get(i);
            list.add(tmp);
        }
        initButtons();
        for (int i = 0; i < 6; i++) {
            final int finalI = i;
            list.get(i).getTranslate(Language.RU, (word) -> {
                    buttonListRight[finalI].setText(word.getWord());
            });
        }
    }

    private void initButtons() {
        buttonListLeft = new Button[] {
                (Button) getView().findViewById(R.id.cardsButtonId0),
                (Button) getView().findViewById(R.id.cardsButtonId2),
                (Button) getView().findViewById(R.id.cardsButtonId4),
                (Button) getView().findViewById(R.id.cardsButtonId6),
                (Button) getView().findViewById(R.id.cardsButtonId8),
                (Button) getView().findViewById(R.id.cardsButtonId10),
        };
        buttonListRight = new Button[] {
                (Button) getView().findViewById(R.id.cardsButtonId1),
                (Button) getView().findViewById(R.id.cardsButtonId3),
                (Button) getView().findViewById(R.id.cardsButtonId5),
                (Button) getView().findViewById(R.id.cardsButtonId7),
                (Button) getView().findViewById(R.id.cardsButtonId9),
                (Button) getView().findViewById(R.id.cardsButtonId11),
        };
        for (int i = 0; i < 6; i++) {
            buttonListLeft[i].setText(list.get(i).getWord());
        }
    }
}
