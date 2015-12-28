package com.yan.compodroid.core.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.yan.compodroid.core.CompodroidComponent;


/**
 * Created by yan.braslavski on 11/18/15.
 *
 * Activity component is connected with a lyfecycle of the target Activity.
 *
 * @param <A> Concrete targeted Activity
 */
public abstract class CompodroidActivityComponent<A extends Activity> extends
        CompodroidComponent<A> {

    public void onCreate(final Bundle savedInstanceState) {
        //Override
    }

    public void onCreateOptionsMenu(final Menu menu) {
        //Override
    }

    public void onOptionsItemSelected(final MenuItem item) {
        //Override
    }

    public void onSaveInstanceState(final Bundle outState) {
        //Override
    }

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        //Override
    }

    public void onDestroy() {
        //Override
    }

    public boolean onBackPressed() {
        //Override
        return false;
    }

    protected void onStart() {
        //Override
    }

    protected void onStop() {
        //Override
    }

    protected void onPause() {
        //Override
    }

    protected void onResume() {
        //Override
    }

    public void onConfigurationChanged(final Configuration newConfig) {
        //Override
    }

    public boolean onCustomEvent(final String name, final Bundle data) {
        //Override
        return false;
    }
}