package com.yan.compodroid.core.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.yan.compodroid.core.CompodroidComponentManager;

import java.util.Collection;

/**
 * Created by Yan-Home on 5/10/2015.
 * Operates on {@link Activity} target object.
 * Delegates {@link Activity} lifecycle events to managed components.
 */
public class CompodroidActivityComponentsManager<A extends Activity> extends
        CompodroidComponentManager<A, CompodroidActivityComponent<A>> {

    public CompodroidActivityComponentsManager(A target) {
        super(target);
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onCreate(final Bundle savedInstanceState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreate(savedInstanceState);
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onCreateOptionsMenu(final Menu menu) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreateOptionsMenu(menu);
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onOptionsItemSelected(final MenuItem item) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onOptionsItemSelected(item);
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onSaveInstanceState(final Bundle outState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onSaveInstanceState(outState);
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onActivityResult(final int requestCode, final int resultCode, Intent data) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onDestroy() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onDestroy();
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public boolean onBackPressed() {
        for (CompodroidActivityComponent component : getComponents()) {
            if (component.onBackPressed())
                return true;
        }
        return false;
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onStart() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onStart();
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onStop() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onStop();
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onPause() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onPause();
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onResume() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onResume();
        }
    }

    /**
     * Call this method from corresponding lyfecycle event of {@link Activity}
     */
    public void onConfigurationChanged(final Configuration newConfig) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onConfigurationChanged(newConfig);
        }
    }

    /**
     * Used to send custom events that every component will recieve.
     *
     * @param eventName event name
     * @param data      event data wrapped in bundle
     * @return true if one or more components consumed the event
     */
    public boolean onCustomEvent(final String eventName, final Bundle data) {
        boolean consumed = false;
        for (CompodroidActivityComponent component : getComponents()) {
            if (component.onCustomEvent(eventName, data))
                consumed = true;
        }
        return consumed;
    }

    @Override
    protected Collection<CompodroidActivityComponent<A>> getComponents() {
        return super.getComponents();
    }
}