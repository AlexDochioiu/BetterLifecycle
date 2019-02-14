package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;
import android.support.annotation.CallSuper;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public interface _LifecycleObserver {
    @CallSuper
    default void onSaveInstanceState(Bundle outState) {
    }

    @CallSuper
    default void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    @CallSuper
    default void onCreate(Bundle savedInstanceState) {
    }

    @CallSuper
    default void onStart() {
    }

    @CallSuper
    default void onResume() {
    }

    @CallSuper
    default void onPause() {
    }

    @CallSuper
    default void onStop() {
    }

    @CallSuper
    default void onDestroy() {
    }
}
