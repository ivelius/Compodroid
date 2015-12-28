package com.yan.compodroid.core;

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
     * Returns concrete object that is "braked" to components.
     *
     * @return target object that all components operate on
     */
    protected T getTarget() {
        return mTarget;
    }
}
