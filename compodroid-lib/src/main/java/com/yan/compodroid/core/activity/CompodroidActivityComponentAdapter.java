package com.yan.compodroid.core.activity;

import android.app.Activity;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.core.CompodroidComponentAdapter;


/**
 * Created by yan.braslavski on 12/15/15.
 *
 * @param <SC>  Source component target
 * @param <DTA> Destination Component Target Activity
 */
public abstract class CompodroidActivityComponentAdapter<SC, DTA extends Activity> extends CompodroidComponentAdapter<DTA,
        CompodroidComponent<SC>, CompodroidActivityComponent<DTA>> {

    public CompodroidActivityComponentAdapter(CompodroidComponent<SC> adaptee) {
        super(adaptee);
    }
}
