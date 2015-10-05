package com.yan.compodroid.systems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;

import com.yan.compodroid.core.CompodroidSystem;
import com.yan.compodroid.utils.ReflectUtils;

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
public class InjectBundleExtraSystem extends CompodroidSystem<Activity> {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface InjectBundleExtra {
        String value();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        final Intent intent = mTarget.getIntent();
        final Bundle extras = intent.getExtras();
        if (intent == null || extras == null)
            return;

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(mTarget.getClass(), InjectBundleExtra.class);
        for (Field field : fieldsToRestore) {
            final String bundleExtraKey = field.getAnnotation(InjectBundleExtra.class).value();
            Serializable serializable = extras.getSerializable(bundleExtraKey);
            ReflectUtils.assignValueToField(mTarget, field, serializable);
        }
    }
}