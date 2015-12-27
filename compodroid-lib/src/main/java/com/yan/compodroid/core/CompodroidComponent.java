package com.yan.compodroid.core;

/**
 * Created by Yan-Home on 5/10/2015.
 *
 * @param <T> Concrete targeted Object
 */
public abstract class CompodroidComponent<T> {
    protected T mTarget;

    public T getTarget() {
        return mTarget;
    }

    public void setTarget(final T target) {
        mTarget = target;
    }
}
