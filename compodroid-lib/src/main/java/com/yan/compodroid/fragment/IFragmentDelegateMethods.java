package com.yan.compodroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yan.braslavski on 1/11/16.
 * Defines methods that Fragment will delegate to its components
 */
public interface IFragmentDelegateMethods {
    public void onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState);

    public void onViewCreated(final View view, final Bundle savedInstanceState);

    public void onDestroyView();

    public void onAttach(final Context context);

    public void onDetach();

    public void onCreate(final Bundle savedInstanceState);

    public void onDestroy();

    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater);

    public void onOptionsItemSelected(final MenuItem item);

    public void onSaveInstanceState(final Bundle outState);

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data);

    public void onStart();

    public void onStop();

    public void onPause();

    public void onResume();

    public void onConfigurationChanged(final Configuration newConfig);

    public void onActivityCreated(final Bundle savedInstanceState);

    public void onViewStateRestored(final Bundle savedInstanceState);
}
