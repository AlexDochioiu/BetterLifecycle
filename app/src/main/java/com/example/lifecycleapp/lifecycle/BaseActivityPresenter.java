package com.example.lifecycleapp.lifecycle;

import android.support.annotation.NonNull;

/**
 * Created by Alex Dochioiu on 11/02/2019
 */
public abstract class BaseActivityPresenter<T extends BaseView>
        extends BasePresenter<_ActivityObserver>
        implements _ActivityObserver<T> {

}
