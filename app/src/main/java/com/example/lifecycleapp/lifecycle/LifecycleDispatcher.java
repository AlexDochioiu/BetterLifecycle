package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public abstract class LifecycleDispatcher<T extends _LifecycleObserver> implements _LifecycleDispatcher<T> {
    final AtomicReference<LifecycleEvents> lastInvokedLifeCycleEvent =
            new AtomicReference<>(LifecycleEvents.NOT_STARTED);

    final Set<T> lifecycleOwners = Collections.synchronizedSet(new LinkedHashSet<>());

    @Override
    public void observe(T lifecycle) {
        lifecycleOwners.add(lifecycle);
    }

    LifecycleEvents getCurrentLifecycleState() {
        return lastInvokedLifeCycleEvent.get();
    }

    void onSaveInstanceStat(Bundle bundle) {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_SAVE_INSTANCE_STATE);
        for (final T item : lifecycleOwners) {
            item.onSaveInstanceState(bundle);
        }
    }

    void onCreate(Bundle savedInstanceState) {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_CREATE);
        for (final T item : lifecycleOwners) {
            item.onCreate(savedInstanceState);
        }
    }

    void onStart() {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_START);
        for (final T item : lifecycleOwners) {
            item.onStart();
        }
    }

    void onStop() {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_STOP);
        for (final T item : lifecycleOwners) {
            item.onStop();
        }
    }

    void onPause() {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_PAUSE);
        for (final T item : lifecycleOwners) {
            item.onPause();
        }
    }

    void onResume() {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_RESUME);
        for (final T item : lifecycleOwners) {
            item.onResume();
        }
    }

    void onDestroy() {
        lastInvokedLifeCycleEvent.set(LifecycleEvents.ON_DESTROY);
        for (final T item : lifecycleOwners) {
            item.onDestroy();
        }
    }
}
