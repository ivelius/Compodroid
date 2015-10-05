package com.yan.compodroid.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

/**
 * This interface exposes various android Activities and Fragment lifecycle
 */
interface ILifecycleDelegate {

    void onCreate(final @NonNull Bundle savedInstanceState);

    void onCreateOptionsMenu(final @NonNull Menu menu);

    void onOptionsItemSelected(final @NonNull MenuItem item);

    void onSaveInstanceState(final @NonNull  Bundle outState);
}
