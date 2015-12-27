package com.yan.compodroid.core.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.yan.compodroid.core.CompodroidComponentManager;

import java.util.Collection;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class CompodroidActivityComponentsManager<A extends Activity> extends
        CompodroidComponentManager<A, CompodroidActivityComponent<A>> {

    public CompodroidActivityComponentsManager(A target) {
        super(target);
    }

    public void onCreate(final Bundle savedInstanceState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreate(savedInstanceState);
        }
    }

    public void onCreateOptionsMenu(final Menu menu) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onCreateOptionsMenu(menu);
        }
    }

    public void onOptionsItemSelected(final MenuItem item) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onOptionsItemSelected(item);
        }
    }

    public void onSaveInstanceState(final Bundle outState) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onSaveInstanceState(outState);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onDestroy() {
        for (CompodroidActivityComponent component : getComponents()) {
            component.onDestroy();
        }
    }

    public boolean onBackPressed() {
        for (CompodroidActivityComponent component : getComponents()) {
            if (component.onBackPressed())
                return true;
        }
        return false;
    }

    /**
     * Recieves custom events with data bundle
     *
     * @param name event name
     * @param data event data
     * @return true if custom event is consumed
     */
    public boolean onCustomEvent(String name, Bundle data) {
        boolean consumed = false;
        for (CompodroidActivityComponent component : getComponents()) {
            if (component.onCustomEvent(name, data))
                consumed = true;
        }
        return consumed;
    }

    @Override
    protected Collection<CompodroidActivityComponent<A>> getComponents() {
        return super.getComponents();
    }
}