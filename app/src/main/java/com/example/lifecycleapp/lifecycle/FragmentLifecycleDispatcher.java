package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
class FragmentLifecycleDispatcher<T extends BaseView> extends LifecycleDispatcher<_FragmentObserver<T>> {
    void onShow() {
        for (final _FragmentObserver item : lifecycleOwners) {
            item.onShow();
        }
    }

    void onHide() {
        for (final _FragmentObserver item : lifecycleOwners) {
            item.onHide();
        }
    }

    void onViewCreated(T provideView, Bundle savedInstanceState) {
        for (final _FragmentObserver<T> item : lifecycleOwners) {
            item.onViewCreated(provideView, savedInstanceState);
        }
    }
}
