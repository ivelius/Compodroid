package com.yan.compodroid.core.fragment;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.core.CompodroidComponentAdapter;
import com.yan.compodroid.core.activity.CompodroidActivityComponent;

import android.app.Activity;
import android.app.Fragment;


/**
 * Created by yan.braslavski on 12/15/15.
 * Adapts any source component to fragment component.
 * @param <SC>  Source component target
 * @param <DTF> Destination Component Target Fragment
 */
public abstract class CompodroidFragmentComponentAdapter<SC, DTF extends Fragment> extends CompodroidComponentAdapter<DTF,
        CompodroidComponent<SC>, CompodroidFragmentComponent<DTF>> {

    public CompodroidFragmentComponentAdapter(CompodroidComponent<SC> adaptee) {
        super(adaptee);
    }
}
