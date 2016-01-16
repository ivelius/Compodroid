package com.example.yanbraslavski.compodroidinjectionspack.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yan-Home on 5/10/2015.
 */
public class ReflectUtils {


    /**
     * Find all annotated fields.
     *
     * @param targetClass class to search annotated fields in
     * @param annotation  to look for
     * @return null safe set
     */
    public static
    Set<Field> findFields(Class<?> targetClass, Class<? extends Annotation> annotation) {
        Set<Field> set = new HashSet<>();
        Class<?> c = targetClass;
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(annotation)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }

    /**
     * Assigns a field value on provided object instance
     *
     * @param target object instance
     * @param field  field of the object instance
     * @param value  value to be assigned to the field
     */
    public static void assignValueToField(final Object target, final Field field, final Object value) {
        try {
            field.setAccessible(true);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
