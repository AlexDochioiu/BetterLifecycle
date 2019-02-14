package com.example.lifecycleapp.lifecycle;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
interface _LifecycleDispatcher<T extends _LifecycleObserver> {
    void observe(final T lifecycle);
}
