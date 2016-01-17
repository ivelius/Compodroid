package com.yan.compodroid.injectionspack.components;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.yan.compodroid.activity.CompodroidActivityComponent;
import com.yan.compodroid.injectionspack.utils.ReflectUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class ViewInjectionComponent extends CompodroidActivityComponent<Activity> {

    private final RootViewProvider mRootViewProvider;

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
    public @interface InjectView {
        int value();
    }

    public interface RootViewProvider {
        View provideRootView();
    }


    public ViewInjectionComponent(final RootViewProvider rootViewProvider) {
        mRootViewProvider = rootViewProvider;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Set<Field> annotatedViewFields = ReflectUtils.findFields(getTarget().getClass(), InjectView.class);
        for (Field field : annotatedViewFields) {
            int viewId = field.getAnnotation(InjectView.class).value();
            ReflectUtils.assignValueToField(getTarget(), field, mRootViewProvider.provideRootView().findViewById(viewId));
        }
    }
}