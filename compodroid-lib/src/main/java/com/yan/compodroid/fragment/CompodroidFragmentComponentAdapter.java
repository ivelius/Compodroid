package com.yan.compodroid.fragment;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.core.CompodroidComponentAdapter;

import android.app.Fragment;


/**
 * Created by yan.braslavski on 12/15/15.
 * Adapts any source component to fragment component.
 * @param <SC>  Source component target
 * @param <DTF> Destination Component Target Fragment
 */
public abstract class CompodroidFragmentComponentAdapter<SC extends CompodroidComponent<?>,
        DTF extends Fragment> extends CompodroidComponentAdapter<DTF,
        SC, CompodroidFragmentComponent<DTF>> {

    public CompodroidFragmentComponentAdapter(SC adaptee) {
        super(adaptee);
    }
}
