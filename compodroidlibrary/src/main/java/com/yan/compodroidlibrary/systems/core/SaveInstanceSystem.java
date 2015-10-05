package com.yan.compodroidlibrary.systems.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;

import com.yan.compodroidlibrary.systems.AbstractSystem;
import com.yan.compodroidlibrary.utils.ReflectUtils;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class SaveInstanceSystem extends AbstractSystem {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SaveInstanceState {
    }

    public SaveInstanceSystem(final Object target) {
        super(target);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        if (savedInstanceState == null)
            return;

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(mTarget.getClass(), SaveInstanceState.class);
        for (Field field : fieldsToRestore) {
            Serializable serializable = savedInstanceState.getSerializable(field.getName());
            ReflectUtils.assignValueToField(mTarget,field, serializable);
        }

    }

    private
    @Nullable
    Pair<String, Serializable> createSaveInstancePair(final Field field) {
        try {
            field.setAccessible(true);
            final Serializable value = (Serializable) field.get(mTarget);
            final String key = field.getName();
            return new Pair<>(key, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        final Set<Field> fieldsToSave = ReflectUtils.findFields(mTarget.getClass(), SaveInstanceState.class);
        for (Field field : fieldsToSave) {
            final Pair<String, Serializable> pair = createSaveInstancePair(field);
            if (pair != null) {
                outState.putSerializable(pair.first, pair.second);
            }
        }
    }


}
