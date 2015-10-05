package com.yan.compodroid.core;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class CompodroidSystemsManager<T> implements ILifecycleDelegate {

    private final LinkedList<CompodroidSystem> mSystems;
    private final T mTarget;

    CompodroidSystemsManager(final T target) {
        mSystems = new LinkedList<>();
        mTarget = target;
    }

    public void addSystem(CompodroidSystem<T> system) {
        system.setTarget(mTarget);
        mSystems.add(system);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        for (CompodroidSystem system : mSystems) {
            system.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu) {
        for (CompodroidSystem system : mSystems) {
            system.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public void onOptionsItemSelected(final MenuItem item) {
        for (CompodroidSystem system : mSystems) {
            system.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        for (CompodroidSystem system : mSystems) {
            system.onSaveInstanceState(outState);
        }
    }
}