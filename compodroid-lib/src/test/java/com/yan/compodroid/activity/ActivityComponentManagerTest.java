package com.yan.compodroid.activity;

import com.yan.compodroid.core.Compodroid;

import org.apache.commons.lang.ClassUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import android.app.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by yan.braslavski on 12/29/15.
 */
public class ActivityComponentManagerTest {

    @Mock
    private Activity mMockActivity;
    private CompodroidActivityComponentsManager mCompManager;
    @Spy
    private MockActivityComponent mActComp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mCompManager = Compodroid.createActivityComponentManager(mMockActivity);
        mCompManager.addComponent(mActComp);

        assertNotNull(mCompManager);
        assertNotNull(mActComp);
        assertTrue(mActComp.isAdded());
        assertEquals(mActComp.getTarget(), mMockActivity);
    }

    @Test
    public void verifyMethodDelegation() throws InvocationTargetException,
            IllegalAccessException, InstantiationException {
        //we are making sure that every method in the interface called
        //on the manager is delegated to attached component
        for (Method m :IActivityDelegateMethods.class.getMethods()){
            Object[] args = new Object[ m.getParameterTypes().length];
            for (int i = 0; i < m.getParameterTypes().length; i++) {
                //mockito cannot mock primitives
                if(m.getParameterTypes()[i].isPrimitive())
                    args[i] = instantiatePrimitive(m.getParameterTypes()[i]);
                else
                    args[i] = mock(m.getParameterTypes()[i]);
            }
            m.invoke(mCompManager,args);
            m.invoke(verify(mActComp),args);
        }
    }

    private Object instantiatePrimitive(Class<?> cls) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        final Class clazz = ClassUtils.primitiveToWrapper(cls);
        return clazz == Boolean.class ? clazz.getConstructors()[0].newInstance(false):
                clazz.getConstructors()[0].newInstance(0);
    }

    private static class MockActivityComponent extends CompodroidActivityComponent<Activity> {
        private boolean added;

        @Override
        protected void onAddedToManager() {
            setAdded(true);
        }

        @Override
        protected void onRemovedFromManager() {
            setAdded(false);
        }

        public boolean isAdded() {
            return added;
        }

        public void setAdded(boolean added) {
            this.added = added;
        }
    }
}