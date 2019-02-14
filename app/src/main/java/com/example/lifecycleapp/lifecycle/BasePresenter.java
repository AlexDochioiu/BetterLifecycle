package com.example.lifecycleapp.lifecycle;

import android.support.annotation.NonNull;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
@SuppressWarnings("WeakerAccess")
abstract class BasePresenter<T extends _LifecycleObserver> implements _LifecycleObserver{
    void bindToLifecycleDispatcher(@NonNull final _LifecycleDispatcher lifecycleDispatcher) {
        //noinspection unchecked
        lifecycleDispatcher.observe((T) this);
    }

}
