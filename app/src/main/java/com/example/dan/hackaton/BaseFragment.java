package com.example.dan.hackaton;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import icepick.Icepick;

/**
 * Created by dan on 23.07.16.
 */

@SuppressWarnings("PMD.AbstractClassWithoutAnyMethod")
public abstract class BaseFragment extends Fragment {


        private Unbinder viewBinder;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Icepick.restoreInstanceState(this, savedInstanceState);
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            viewBinder = ButterKnife.bind(this, view);
        }

        private boolean isFragmentAlive() {
            return getActivity() != null && isAdded() && !isDetached() && getView() != null && !isRemoving();
        }

        public void enableHomeButton(boolean enable) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        }

        public void setActionBarTitle(int titleId) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getResources().getString(titleId));
        }

        public void setActionBarTitle(String title) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        }

        @Override
        public void onDestroyView() {
            if (viewBinder != null) {
                viewBinder.unbind();
            }
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            Icepick.saveInstanceState(this, outState);
        }
}

