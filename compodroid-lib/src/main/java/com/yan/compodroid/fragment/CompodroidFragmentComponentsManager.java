package com.yan.compodroid.fragment;

import com.yan.compodroid.core.CompodroidComponentManager;

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

import java.util.Collection;

/**
 * Created by Yan-Home on 5/10/2015.
 * Operates on {@link Fragment} target object.
 * Delegates {@link Fragment} lifecycle events to managed components.
 */
public class CompodroidFragmentComponentsManager<F extends Fragment> extends
        CompodroidComponentManager<F, CompodroidFragmentComponent<F>>
        implements IFragmentDelegateMethods {

    public CompodroidFragmentComponentsManager(F target) {
        super(target);
    }


    @Override
    public void addComponent(CompodroidFragmentComponent<F> component) {
        super.addComponent(component);
    }

    @Override
    public boolean removeComponent(CompodroidFragmentComponent<F> component) {
        return super.removeComponent(component);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onOptionsItemSelected(final MenuItem item) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onSaveInstanceState(final Bundle outState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onSaveInstanceState(outState);
        }
    }


    @Override
    public void onActivityResult(final int requestCode, final int resultCode, Intent data) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onDestroy();
        }
    }

    @Override
    public void onStart() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onStart();
        }
    }

    @Override
    public void onStop() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onStop();
        }
    }

    @Override
    public void onPause() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onPause();
        }
    }

    @Override
    public void onResume() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onResume();
        }
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu,final MenuInflater inflater) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onCreateOptionsMenu(menu,inflater);
        }
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onActivityCreated(savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(final Bundle savedInstanceState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onViewStateRestored(savedInstanceState);
        }
    }

    @Override
    public void onCreateView(final LayoutInflater inflater, final ViewGroup container,final Bundle savedInstanceState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onCreateView(inflater,container,savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(final View view,final Bundle savedInstanceState) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onViewCreated(view,savedInstanceState);
        }
    }

    @Override
    public void onDestroyView() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onDestroyView();
        }
    }

    @Override
    public void onAttach(final Context context) {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onAttach(context);
        }
    }

    @Override
    public void onDetach() {
        for (CompodroidFragmentComponent component : getComponents()) {
            component.onDetach();
        }
    }

    @Override
    protected Collection<CompodroidFragmentComponent<F>> getComponents() {
        return super.getComponents();
    }
}