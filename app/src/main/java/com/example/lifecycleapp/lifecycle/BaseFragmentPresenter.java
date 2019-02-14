package com.example.lifecycleapp.lifecycle;

import android.support.annotation.NonNull;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public abstract class BaseFragmentPresenter<T extends BaseView> extends BasePresenter<_FragmentObserver> implements _FragmentObserver<T> {
}
