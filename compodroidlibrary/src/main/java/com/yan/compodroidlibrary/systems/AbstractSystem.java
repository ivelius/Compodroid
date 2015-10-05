package com.yan.compodroidlibrary.systems;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.yan.compodroidlibrary.ISystem;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class AbstractSystem<T> implements ISystem {
    protected final T mTarget;

    public AbstractSystem(final T target) {
        mTarget = target;
    }


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
}
