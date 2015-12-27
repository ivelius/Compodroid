package com.yan.compodroid.core;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by yan.braslavski on 12/15/15.
 *
 * Basic component magager , can be extended for concrete implementations.
 */
public class CompodroidComponentManager<T, C extends CompodroidComponent<T>> {

    protected final LinkedList<C> mComponents;
    private final T mTarget;

    public CompodroidComponentManager(final T target) {
        mComponents = new LinkedList<>();
        mTarget = target;
    }

    public void addComponent(C component) {
        component.setTarget(mTarget);
        mComponents.add(component);
    }

    protected Collection<C> getComponents() {
        return mComponents;
    }

    protected T getTarget() {
        return mTarget;
    }
}
