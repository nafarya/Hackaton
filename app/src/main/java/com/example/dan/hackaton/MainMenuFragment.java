package com.example.dan.hackaton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;

/**
 * Created by dan on 23.07.16.
 */
public class MainMenuFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu, container, false);

        initButtons(view);
        return view;
    }

    private void initButtons(View view) {
        Button searchForPairButton = (Button) view.findViewById(R.id.searchForPairButtonId);
        searchForPairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchForPairFragment searchForPairFragment = new SearchForPairFragment();
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container, searchForPairFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }
}
