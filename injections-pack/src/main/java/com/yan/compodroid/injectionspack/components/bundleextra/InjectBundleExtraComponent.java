package com.yan.compodroid.injectionspack.components.bundleextra;

import android.os.Bundle;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.injectionspack.utils.ReflectUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 *
 * A Generic component capable of injection of values taken from extra fields of an intent
 * into target class fields.
 */
public class InjectBundleExtraComponent extends CompodroidComponent<Object> {

    @Override
    protected void onAddedToManager() {
        //Not implemented
    }

    @Override
    protected void onRemovedFromManager() {
        //Not implemented
    }

    public void injectBundleExtra(final Bundle bundleExtra, Object target) {
        if (bundleExtra == null)
            throw new IllegalArgumentException("Extra Bundle cannot be null");

        final Set<Field> fieldsToRestore = ReflectUtils.findFields(target.getClass(), InjectBundleExtra.class);
        for (Field field : fieldsToRestore) {
            final String bundleExtraKey = field.getAnnotation(InjectBundleExtra.class).value();
            Serializable serializable = bundleExtra.getSerializable(bundleExtraKey);
            ReflectUtils.assignValueToField(target, field, serializable);
        }
    }
}