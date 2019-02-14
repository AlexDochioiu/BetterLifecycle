package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public abstract class BaseLifecycleActivity<Y extends BaseView, T extends BaseActivityPresenter<Y>> extends AppCompatActivity {
    private final ActivityLifecycleDispatcher<Y, _ActivityObserver<Y>> lifecycleDispatcher = new ActivityLifecycleDispatcher<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doDaggerInject();
        Preconditions.checkNotNull(getPresenter(), "getPresenter() MUST NOT return null after doDaggerInject() is called")
                .bindToLifecycleDispatcher(lifecycleDispatcher);

        lifecycleDispatcher.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        lifecycleDispatcher.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (lifecycleDispatcher.getCurrentLifecycleState().equals(LifecycleEvents.ON_CREATE)) {
            lifecycleDispatcher.onViewCreated(Preconditions.castNotNull(this));
        }
        lifecycleDispatcher.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        lifecycleDispatcher.onResume();
    }

    @Override
    protected void onPause() {
        lifecycleDispatcher.onPause();

        super.onPause();
    }

    @Override
    protected final void onSaveInstanceState(Bundle outState) {
        lifecycleDispatcher.onSaveInstanceStat(outState);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        lifecycleDispatcher.onStop();

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        lifecycleDispatcher.onDestroy();

        super.onDestroy();
    }

    //TODO move those two in interface
    /**
     * Dagger injection should be done in this method
     *
     * NOTE: After this method call, the presenter {@link T} must have a non-null value!
     */
    protected abstract void doDaggerInject();

    /**
     * This method will be called after {@link #doDaggerInject()} to allow dagger to initialize the
     * presenter
     *
     * @return the presenter
     */
    protected abstract T getPresenter();
}
