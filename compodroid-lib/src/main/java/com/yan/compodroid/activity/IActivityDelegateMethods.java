package com.yan.compodroid.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by yan.braslavski on 1/11/16.
 * Defines methods that Activity will delegate to its components
 */
public interface IActivityDelegateMethods {

    public void onCreate(final Bundle savedInstanceState);

    public void onCreateOptionsMenu(final Menu menu);

    public void onOptionsItemSelected(final MenuItem item);

    public void onSaveInstanceState(final Bundle outState);

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data);

    public void onDestroy();

    public boolean onBackPressed();

    public void onStart();

    public void onStop();

    public void onPause();

    public void onResume();

    public void onConfigurationChanged(final Configuration newConfig);
}
