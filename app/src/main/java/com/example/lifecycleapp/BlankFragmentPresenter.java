package com.example.lifecycleapp;

import android.os.Bundle;
import android.util.Log;

import com.example.lifecycleapp.lifecycle.BaseFragmentPresenter;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public class BlankFragmentPresenter extends BaseFragmentPresenter<BlankFragmentView> {

    private String TAG = "CLOG_FragmentPresenter";

    @SuppressWarnings("WeakerAccess")
    public BlankFragmentPresenter() {
        this.TAG = "CLOG_FragPresenter@" + Integer.toString(this.hashCode(), 16);
    }

    @Override
    public void onShow() {
        super.onShow();
        Log.e(TAG, "onShow: ");
    }

    @Override
    public void onHide() {
        super.onHide();
        Log.e(TAG, "onHide: ");
    }

    @Override
    public void onViewCreated(BlankFragmentView provideView, Bundle savedInstanceState) {
        super.onViewCreated(provideView, savedInstanceState);
        Log.e(TAG, "onViewCreated: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
