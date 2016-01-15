package com.yan.compodroid.core.fragment;

import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.core.activity.IActivityDelegateMethods;

import org.apache.commons.lang.ClassUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import android.app.Fragment;

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
public class FragmentComponentManagerTest {

    @Mock
    private Fragment mMockFragment;
    private CompodroidFragmentComponentsManager mCompManager;
    @Spy
    private MockFragmentComponent mFragmentComponent;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mCompManager = Compodroid.createFragmentComponentManager(mMockFragment);
        mCompManager.addComponent(mFragmentComponent);

        assertNotNull(mCompManager);
        assertNotNull(mFragmentComponent);
        assertTrue(mFragmentComponent.isAdded());
        assertEquals(mFragmentComponent.getTarget(), mMockFragment);
    }

    @Test
    public void verifyMethodDelegation() throws InvocationTargetException,
            IllegalAccessException, InstantiationException {
        //we are making sure that every method in the interface called
        //on the manager is delegated to attached component
        for (Method m :IFragmentDelegateMethods.class.getMethods()){
            Object[] args = new Object[ m.getParameterTypes().length];
            for (int i = 0; i < m.getParameterTypes().length; i++) {
                //mockito cannot mock primitives
                if(m.getParameterTypes()[i].isPrimitive())
                    args[i] = instantiatePrimitive(m.getParameterTypes()[i]);
                else
                    args[i] = mock(m.getParameterTypes()[i]);
            }
            m.invoke(mCompManager,args);
            m.invoke(verify(mFragmentComponent),args);
        }
    }

    private Object instantiatePrimitive(Class<?> cls) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        final Class clazz = ClassUtils.primitiveToWrapper(cls);
        return clazz == Boolean.class ? clazz.getConstructors()[0].newInstance(false):
                clazz.getConstructors()[0].newInstance(0);
    }

    private static class MockFragmentComponent extends CompodroidFragmentComponent<Fragment> {
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