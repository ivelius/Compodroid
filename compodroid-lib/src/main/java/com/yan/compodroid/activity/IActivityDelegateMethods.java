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

    void onCreate(final Bundle savedInstanceState);

    void onCreateOptionsMenu(final Menu menu);

    void onOptionsItemSelected(final MenuItem item);

    void onSaveInstanceState(final Bundle outState);

    void onActivityResult(final int requestCode, final int resultCode, final Intent data);

    void onDestroy();

    boolean onBackPressed();

    void onStart();

    void onStop();

    void onPause();

    void onResume();

    void onConfigurationChanged(final Configuration newConfig);

    void onNewIntent(final Intent intent);
}
