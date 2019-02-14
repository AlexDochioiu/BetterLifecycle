package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;

/**
 * Created by Alex Dochioiu on 13/02/2019
 */
public class ActivityLifecycleDispatcher <T extends BaseView, Y extends _ActivityObserver<T>> extends LifecycleDispatcher<Y>{

    void onViewCreated(T provideView) {
        for (final _ActivityObserver<T> item : lifecycleOwners) {
            item.onViewCreated(provideView);
        }
    }

    void onRestoreInstanceState(Bundle savedInstanceState) {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_RESTORE_INSTATNCE_STATE);
        for (final Y item : lifecycleOwners) {
            item.onRestoreInstanceState(savedInstanceState);
        }
    }
}
