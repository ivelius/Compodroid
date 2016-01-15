package com.yan.compodroid.core.fragment;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.core.activity.IActivityDelegateMethods;

import android.app.Activity;
import android.app.Fragment;
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
 * Created by yan.braslavski on 11/18/15.
 *
 * Fragment component is connected with a lyfecycle of the target Fragment.
 *
 * @param <F> Concrete targeted Fragment
 */
public abstract class CompodroidFragmentComponent<F extends Fragment> extends
        CompodroidComponent<F> implements IFragmentDelegateMethods {

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Override
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //Override
    }

    @Override
    public void onDestroyView() {
        //Override
    }

    @Override
    public void onAttach(Context context) {
        //Override
    }

    @Override
    public void onDetach() {
        //Override
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //Override
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //Override
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        //Override
    }

    @Override
    protected void onAddedToManager() {
        //Override
    }

    @Override
    protected void onRemovedFromManager() {
        //Override
    }
}