package com.yan.compodroid.core;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public abstract class CompodroidSystem<T> implements ILifecycleDelegate {
    protected T mTarget;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        //Override
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu) {
        //Override
    }

    @Override
    public void onOptionsItemSelected(final MenuItem item) {
        //Override
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        //Override
    }


    public T getTarget() {
        return mTarget;
    }

    public void setTarget(final T target) {
        mTarget = target;
    }
}
