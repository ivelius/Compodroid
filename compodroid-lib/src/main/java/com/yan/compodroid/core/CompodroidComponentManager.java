package com.yan.compodroid.core;

import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yan.braslavski on 12/15/15.
 *
 * Basic component magager , can be extended for concrete implementations.
 */
public class CompodroidComponentManager<T, C extends CompodroidComponent<T>> {

    private final LinkedList<C> mComponents;
    private final T mTarget;
    private final List<C> mUnmodifiableCollectionOfComponents;

    /**
     * Creates component manager
     *
     * @param target object that components operate on.
     */
    protected CompodroidComponentManager(final T target) {
        if (target == null)
            throw new IllegalArgumentException("Target object cannot be null !");
        mComponents = new LinkedList<>();
        mUnmodifiableCollectionOfComponents = Collections.unmodifiableList(mComponents);
        mTarget = target;
    }

    /**
     * Adds a components to the manager.
     * Note that duplications are possible.
     * The same component can be added multiple times.
     *
     * @param component that will operate on target object and will be managed by this manager.
     */
    public void addComponent(final C component) {
        if (component == null)
            throw new IllegalArgumentException("Added component cannot be null !");
        component.setTarget(mTarget);
        mComponents.add(component);
        component.onAddedToManager();
    }

    /**
     * Removes the component from the manager.
     * Requires the exact instance of a component to be removed
     *
     * @return true if component was removed , false otherwise
     * @param component to be removed.
     */
    public boolean removeComponent(final C component) {
        if (component == null)
            throw new IllegalArgumentException("Remove component cannot be null !");
        boolean isRemoved = mComponents.remove(component);
        if(isRemoved)
            component.onRemovedFromManager();
        return isRemoved;
    }

    /**
     * Used to send custom events that every component will recieve.
     *
     * @param eventName event name
     * @param data      event data wrapped in bundle
     * @return true if one or more components consumed the event
     */
    public boolean onCustomEvent(final String eventName, final Bundle data) {
        boolean consumed = false;
        for (CompodroidComponent component : getComponents()) {
            if (component.onCustomEvent(eventName, data))
                consumed = true;
        }
        return consumed;
    }

    /**
     * Returnes all the components managed by this manager
     *
     * @return unmodifiable collection of components
     */
    protected Collection<C> getComponents() {
        return mUnmodifiableCollectionOfComponents;
    }

    /**
     * Returns concrete object that is "broken" into components.
     *
     * @return target object that all components operate on
     */
    protected T getTarget() {
        return mTarget;
    }
}
