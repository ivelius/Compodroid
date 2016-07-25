package com.yan.compodroid.activity;

import com.yan.compodroid.core.CompodroidComponentManager;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Collection;

/**
 * Created by Yan-Home on 5/10/2015.
 * Operates on {@link Activity} target object.
 * Delegates {@link Activity} lifecycle events to managed components.
 */
public class CompodroidActivityComponentsManager<A extends Activity> extends
        CompodroidComponentManager<A, CompodroidActivityComponent<A>>
        implements IActivityDelegateMethods {

    public CompodroidActivityComponentsManager(A target) {
        super(target);
    }

    @Override
    public void addComponent(CompodroidActivityComponent<A> component) {
        super.addComponent(component);
    }

    @Override
    public boolean removeComponent(CompodroidActivityComponent<A> component) {
        return super.removeComponent(component);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreate(savedInstanceState);
        }
    }


    @Override
    public void onCreateOptionsMenu(final Menu menu) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreateOptionsMenu(menu);
        }
    }


    @Override
    public void onOptionsItemSelected(final MenuItem item) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onSaveInstanceState(final Bundle outState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onSaveInstanceState(outState);
        }
    }


    @Override
    public void onActivityResult(final int requestCode, final int resultCode, Intent data) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onDestroy();
        }
    }


    @Override
    public boolean onBackPressed() {
        for (CompodroidActivityComponent component : getComponents()) {
            if (component.onBackPressed())
                return true;
        }
        return false;
    }


    @Override
    public void onStart() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onStart();
        }
    }


    @Override
    public void onStop() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onStop();
        }
    }


    @Override
    public void onPause() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onPause();
        }
    }


    @Override
    public void onResume() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onResume();
        }
    }


    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onConfigurationChanged(newConfig);
        }
    }

    @Override
    protected Collection<CompodroidActivityComponent<A>> getComponents() {
        return super.getComponents();
    }

    @Override
    public void onNewIntent(Intent intent) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onNewIntent(intent);
        }
    }
}