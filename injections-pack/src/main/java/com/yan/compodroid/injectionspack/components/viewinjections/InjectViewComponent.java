package com.yan.compodroid.injectionspack.components.viewinjections;

import com.yan.compodroid.core.CompodroidComponent;
import com.yan.compodroid.injectionspack.utils.ReflectUtils;

import android.view.View;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class InjectViewComponent extends CompodroidComponent<Object> {

    @Override
    protected void onAddedToManager() {
    }

    @Override
    protected void onRemovedFromManager() {
    }

    public void injectViews(final View rootView, Object target) {
        final Set<Field> annotatedViewFields = ReflectUtils.findFields(target.getClass(), InjectView.class);
        for (Field field : annotatedViewFields) {
            int viewId = field.getAnnotation(InjectView.class).value();
            ReflectUtils.assignValueToField(target, field, rootView.findViewById(viewId));
        }
    }
}