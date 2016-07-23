package com.example.dan.hackaton;

/**
 * Created by dan on 23.07.16.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dan.hackaton.lang.Language;
import com.example.dan.hackaton.lang.Word;

import butterknife.BindView;
//import ru.yandex.yamblz.languagelearning.R;
//import ru.yandex.yamblz.languagelearning.lang.Language;
//import ru.yandex.yamblz.languagelearning.lang.Word;

/**
 * Created by root on 7/23/16.
 */
public class AccordanceFragment extends BaseFragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_for_pair_fragment, container, false);
    }


}