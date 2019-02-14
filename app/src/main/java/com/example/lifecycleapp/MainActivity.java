package com.example.lifecycleapp;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.lifecycleapp.lifecycle.BaseLifecycleActivity;
import com.example.lifecycleapp.other.HomeWatcher;

public class MainActivity extends BaseLifecycleActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {

    private static final String FRAGMENT_TAG = "fragment_tag";
    private static final String TAG = "CLOG_MainActivity";

    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeWatcher mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                Log.w(TAG, "GETTING IN/OUT OF APPLICATION");
                // do something here...
            }
            @Override
            public void onHomeLongPressed() {
            }
        });
        mHomeWatcher.startWatch();

        Log.w(TAG, "onCreate: finished");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        final FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                Log.w(TAG, "REPLACE FRAGMENT");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, BlankFragment.newInstance(), FRAGMENT_TAG)
                        .commit();
                return true;
            case R.id.navigation_dashboard:
                if (fragment != null) {
                    if (fragment.isHidden()) {
                        Log.w(TAG, "SHOW FRAGMENT");
                        fragmentManager.beginTransaction()
                                .show(fragment)
                                .commit();
                    } else {
                        Log.w(TAG, "HIDE FRAGMENT");
                        fragmentManager.beginTransaction()
                                .hide(fragment)
                                .commit();
                    }
                } else {
                    Log.w(TAG, "show/hide: no fragment found in manager to show/hide");
                }
                return true;
            case R.id.navigation_notifications:
                if (fragment != null) {
                    if (fragment.isDetached()) {
                        Log.w(TAG, "ATTACH FRAGMENT");
                        fragmentManager.beginTransaction()
                                .attach(fragment)
                                .commit();
                    } else {
                        Log.w(TAG, "DETACH FRAGMENT");
                        fragmentManager.beginTransaction()
                                .detach(fragment)
                                .commit();
                    }
                } else {
                    Log.w(TAG, "attach/detach: no fragment found in manager to attach/detach");
                }
                return true;
        }
        return false;
    };

    @Override
    protected void doDaggerInject() {
        mainActivityPresenter = new MainActivityPresenter();
    }

    @Override
    protected MainActivityPresenter getPresenter() {
        return mainActivityPresenter;
    }

}
