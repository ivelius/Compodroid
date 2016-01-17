package com.yan.compodroid.activity;

import android.app.Activity;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.core.CompodroidComponentAdapter;

/**
 * Created by yan.braslavski on 12/15/15.
 *
 * @param <SC>  Source component
 * @param <DTA> Destination Component Target Activity
 */
public abstract class CompodroidActivityComponentAdapter<SC extends CompodroidComponent<?>,
        DTA extends Activity> extends CompodroidComponentAdapter<DTA,
        SC, CompodroidActivityComponent<DTA>> {

    public CompodroidActivityComponentAdapter(SC adaptee) {
        super(adaptee);
    }
}
