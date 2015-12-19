package com.yan.compodroid.core.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.yan.compodroid.core.CompodroidComponent;


/**
 * Created by yan.braslavski on 11/18/15.
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Override
    }

    public void onDestroy() {
        //Override
    }

    public boolean onBackPressed() {
        //Override
        return false;
    }

    public boolean onCustomEvent(String name, Bundle data) {
        //Override
        return false;
    }
}
