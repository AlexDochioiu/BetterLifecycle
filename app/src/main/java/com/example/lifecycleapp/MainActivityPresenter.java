package com.example.lifecycleapp;

import android.os.Bundle;
import android.util.Log;

import com.example.lifecycleapp.lifecycle.BaseActivityPresenter;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityView> {
    private static final String TAG = "CLOG_ActivityPresenter";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("test", "test");
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onViewCreated(MainActivityView provideView) {
        super.onViewCreated(provideView);
        Log.d(TAG, "onViewCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
