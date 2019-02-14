package com.example.lifecycleapp.lifecycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public abstract class BaseLifecycleFragment<Y extends BaseView, T extends BaseFragmentPresenter<Y>> extends Fragment {
    private final FragmentLifecycleDispatcher<Y> lifecycleDispatcher = new FragmentLifecycleDispatcher<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doDaggerInject();
        Preconditions.checkNotNull(getPresenter(), "getPresenter() MUST NOT return null after doDaggerInject() is called")
                .bindToLifecycleDispatcher(lifecycleDispatcher);

        lifecycleDispatcher.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lifecycleDispatcher.onViewCreated(Preconditions.castNotNull(this), savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        lifecycleDispatcher.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        lifecycleDispatcher.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (hidden) {
            lifecycleDispatcher.onHide();
            lifecycleDispatcher.onPause();
            lifecycleDispatcher.onStop();

            super.onHiddenChanged(hidden);
        } else {
            super.onHiddenChanged(hidden);

            lifecycleDispatcher.onStart();
            lifecycleDispatcher.onResume();
            lifecycleDispatcher.onShow();
        }
    }

    @Override
    public void onPause() {
        lifecycleDispatcher.onPause();

        super.onPause();
    }

    @Override
    public final void onSaveInstanceState(@NonNull Bundle outState) {
        lifecycleDispatcher.onSaveInstanceStat(outState);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        lifecycleDispatcher.onStop();

        super.onStop();
    }

    @Override
    public void onDestroy() {
        lifecycleDispatcher.onDestroy();

        super.onDestroy();
    }

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
