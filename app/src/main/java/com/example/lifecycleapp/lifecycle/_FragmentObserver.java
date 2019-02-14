package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;
import android.support.annotation.CallSuper;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public interface _FragmentObserver<T extends BaseView> extends _LifecycleObserver {

    @CallSuper
    default void onShow() {
    }

    @CallSuper
    default void onHide() {
    }

    @CallSuper
    default void onViewCreated(T provideView, Bundle savedInstanceState) {

    }
}
