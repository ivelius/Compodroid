package com.yan.compodroidlibrary.systems.core;

import android.os.Bundle;
import android.view.View;

import com.yan.compodroidlibrary.systems.AbstractSystem;
import com.yan.compodroidlibrary.utils.ReflectUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class ViewInjectionSystem extends AbstractSystem<Object> {

    private final RootViewProvider mRootViewProvider;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface InjectView {
        int value();
    }

    public interface RootViewProvider {
        View provideRootView();
    }


    public ViewInjectionSystem(final Object target, final RootViewProvider rootViewProvider) {
        super(target);
        mRootViewProvider = rootViewProvider;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Set<Field> annotatedViewFields = ReflectUtils.findFields(mTarget.getClass(), InjectView.class);
        for (Field field : annotatedViewFields) {
            int viewId = field.getAnnotation(InjectView.class).value();
            ReflectUtils.assignValueToField(mTarget, field, mRootViewProvider.provideRootView().findViewById(viewId));
        }
    }
}