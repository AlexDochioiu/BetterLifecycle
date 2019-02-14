package com.example.lifecycleapp.lifecycle;

import android.support.annotation.CallSuper;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public interface _ActivityObserver<T extends BaseView> extends _LifecycleObserver {

    @CallSuper
    default void onViewCreated(T provideView) {

    }

}
