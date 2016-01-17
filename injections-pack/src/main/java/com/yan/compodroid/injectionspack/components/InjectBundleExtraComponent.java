package com.yan.compodroid.injectionspack.components;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yan.compodroid.core.activity.CompodroidActivityComponent;
import com.yan.compodroid.injectionspack.utils.ReflectUtils;

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
public class InjectBundleExtraComponent extends CompodroidActivityComponent<Activity> {

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
    public @interface InjectBundleExtra {
        String value();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        final Intent intent = getTarget().getIntent();
        final Bundle extras = intent.getExtras();
        if (intent == null || extras == null)
            return;

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(getTarget().getClass(), InjectBundleExtra.class);
        for (Field field : fieldsToRestore) {
            final String bundleExtraKey = field.getAnnotation(InjectBundleExtra.class).value();
            Serializable serializable = extras.getSerializable(bundleExtraKey);
            ReflectUtils.assignValueToField(getTarget(), field, serializable);
        }
    }
}