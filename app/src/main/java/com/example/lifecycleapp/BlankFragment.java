package com.example.lifecycleapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecycleapp.lifecycle.BaseLifecycleFragment;


public class BlankFragment extends BaseLifecycleFragment<BlankFragmentView, BlankFragmentPresenter> implements BlankFragmentView {
    private BlankFragmentPresenter presenter;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    @Override
    protected void doDaggerInject() {
        // injecting dagger should assign presenter
        presenter = new BlankFragmentPresenter();
    }

    @Override
    protected BlankFragmentPresenter getPresenter() {
        return presenter;
    }
}
