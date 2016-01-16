package com.example.yanbraslavski.compodroidinjectionspack.components;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;

import com.yan.compodroid.core.activity.CompodroidActivityComponent;
import com.example.yanbraslavski.compodroidinjectionspack.utils.ReflectUtils;

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
public class SaveInstanceComponent extends CompodroidActivityComponent<Activity> {

    @Override
    protected void onAddedToManager() {
        //TODO : implement dynamic addition
    }

    @Override
    protected void onRemovedFromManager() {
        //TODO : implement dynamic removal
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SaveInstanceState {
    }


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        if (savedInstanceState == null)
            return;

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(getTarget().getClass(), SaveInstanceState.class);
        for (Field field : fieldsToRestore) {
            Serializable serializable = savedInstanceState.getSerializable(field.getName());
            ReflectUtils.assignValueToField(getTarget(),field, serializable);
        }

    }

    private
    Pair<String, Serializable> createSaveInstancePair(final Field field) {
        try {
            field.setAccessible(true);
            final Serializable value = (Serializable) field.get(getTarget());
            final String key = field.getName();
            return new Pair<>(key, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        final Set<Field> fieldsToSave = ReflectUtils.findFields(getTarget().getClass(), SaveInstanceState.class);
        for (Field field : fieldsToSave) {
            final Pair<String, Serializable> pair = createSaveInstancePair(field);
            if (pair != null) {
                outState.putSerializable(pair.first, pair.second);
            }
        }
    }


}
