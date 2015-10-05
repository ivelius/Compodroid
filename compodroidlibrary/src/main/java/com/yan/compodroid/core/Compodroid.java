package com.yan.compodroid.core;

import android.support.annotation.NonNull;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class Compodroid {

    /**
     * Creates a system manager that operates on target , as long as target is alive.
     *
     * @param target target that systems operate on
     * @param <T>    Target type
     * @return new instance of {@link CompodroidSystemsManager}
     */
    public static <T> CompodroidSystemsManager createSystemManager(final @NonNull T target) {
        return new CompodroidSystemsManager(target);
    }
}
