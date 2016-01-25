package com.yan.compodroid.injectionspack.components.saveinstancestate;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.injectionspack.utils.ReflectUtils;

import android.os.Bundle;
import android.util.Pair;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 * A Generic component capable of injection of values taken from saved instance state bundle of an intent
 * into target class fields.
 */
public class SaveInstanceComponent extends CompodroidComponent<Object> {

    public void restoreInstanceState(final Bundle savedInstanceState, Object target) {
        if (savedInstanceState == null)
            return;

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(target.getClass(), SaveInstanceState.class);
        for (Field field : fieldsToRestore) {
            Serializable serializable = savedInstanceState.getSerializable(field.getName());
            ReflectUtils.assignValueToField(target, field, serializable);
        }

    }

    private Pair<String, Serializable> createSaveInstancePair(final Field field, Object target) {
        try {
            field.setAccessible(true);
            final Serializable value = (Serializable) field.get(target);
            final String key = field.getName();
            return new Pair<>(key, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveInstanceState(final Bundle outState, Object target) {
        final Set<Field> fieldsToSave = ReflectUtils.findFields(target.getClass(), SaveInstanceState.class);
        for (Field field : fieldsToSave) {
            final Pair<String, Serializable> pair = createSaveInstancePair(field, target);
            if (pair != null) {
                outState.putSerializable(pair.first, pair.second);
            }
        }
    }


    @Override
    protected void onAddedToManager() {
        //Not Implemented
    }

    @Override
    protected void onRemovedFromManager() {
        //Not Implemented
    }
}
