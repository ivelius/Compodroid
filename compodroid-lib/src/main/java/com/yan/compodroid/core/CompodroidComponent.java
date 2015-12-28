package com.yan.compodroid.core;

/**
 * Created by Yan-Home on 5/10/2015.
 *
 * @param <T> Concrete targeted Object
 */
public abstract class CompodroidComponent<T> {
    protected T mTarget;

    /**
     * Returns concrete object that is "braked" to components.
     *
     * @return target object that all components operate on
     */
    public T getTarget() {
        return mTarget;
    }

    /**
     * For internal use by {@link CompodroidComponentManager}
     *
     * @param target object that all components operate on
     */
    protected void setTarget(final T target) {
        mTarget = target;
    }
}
