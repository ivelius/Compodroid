package com.yan.compodroid.core;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class CompodroidSystemsManager implements ILifecycleDelegate {

    private final LinkedList<ISystem> mSystems;

    public CompodroidSystemsManager() {
        mSystems = new LinkedList<>();
    }

    public void addSystem(ISystem system) {
        mSystems.add(system);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        for (ISystem system : mSystems) {
            system.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu) {
        for (ISystem system : mSystems) {
            system.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public void onOptionsItemSelected(final MenuItem item) {
        for (ISystem system : mSystems) {
            system.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        for (ISystem system : mSystems) {
            system.onSaveInstanceState(outState);
        }
    }
}