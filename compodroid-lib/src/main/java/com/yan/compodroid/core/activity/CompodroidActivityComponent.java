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
        CompodroidComponent<A> implements IActivityDelegateMethods{

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

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        //Override
    }

    @Override
    public void onDestroy() {
        //Override
    }

    @Override
    public boolean onBackPressed() {
        //Override
        return false;
    }

    @Override
    public void onStart() {
        //Override
    }

    @Override
    public void onStop() {
        //Override
    }

    @Override
    public void onPause() {
        //Override
    }

    @Override
    public void onResume() {
        //Override
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        //Override
    }
}