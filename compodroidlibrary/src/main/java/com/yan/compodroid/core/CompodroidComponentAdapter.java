package com.yan.compodroid.core;

/**
 * Created by yan.braslavski on 12/15/15.
 *
 * Component adapter responsible for adaptation of any given component type
 * to any other given component type.
 *
 * Generic components can be reused according different targets by using Adapters.
 * For example the same component can be used in activity and in fragment , for
 * that purpose it just need to be adapted for 2 different component managers.
 *
 * @param <DT> Destination Target
 * @param <IC> Input Component
 * @param <OC> Output Component
 */
public abstract class CompodroidComponentAdapter<DT,
        IC extends CompodroidComponent<?>,
        OC extends CompodroidComponent<DT>> {

    private final IC mAdaptee;

    public CompodroidComponentAdapter(IC adaptee){
        mAdaptee = adaptee;
    }

    /**
     * Generates adapted component
     */
    public abstract OC adapt();

    public IC getAdaptee() {
        return mAdaptee;
    }
}
