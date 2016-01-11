package com.yan.compodroid.core;

import android.os.Bundle;

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

    /**
     * Called immideatley after is added to {@link CompodroidComponentManager}
     */
    protected abstract void onAddedToManager();

    /**
     * Called immideatley after removed {@link CompodroidComponentManager}
     */
    protected abstract void onRemovedFromManager();

    /**
     * Used to send custom events that component will recieve.
     *
     * @param eventName event name
     * @param data      event data wrapped in bundle
     * @return true if one or more components consumed the event
     */
    public boolean onCustomEvent(final String name, final Bundle data) {
        //Override
        return false;
    }
}
