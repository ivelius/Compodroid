package com.yan.compodroid.core;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.verify;

/**
 * Created by yan.braslavski on 12/29/15.
 */
public class GenericComponentManagerTest {

    @Mock
    private Object mMockTarget;
    private CompodroidComponentManager<Object, CompodroidComponent<Object>> mCompManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mCompManager = Compodroid.createGenericComponentManager(mMockTarget);
    }

    @Test
    public void componentAdditionAndRemoval() {
        MockCompodroidComponent mockComp = new MockCompodroidComponent();
        mCompManager.addComponent(mockComp);
        assertTrue(mockComp.isAdded());
        mCompManager.removeComponent(mockComp);
        assertFalse(mockComp.isAdded());
    }

    @Test
    public void multipleComponents() {
        MockCompodroidComponent mockCompOne = new MockCompodroidComponent();
        MockCompodroidComponent mockCompTwo = new MockCompodroidComponent();
        MockCompodroidComponent mockCompThree = new MockCompodroidComponent();
        mCompManager.addComponent(mockCompOne);
        mCompManager.addComponent(mockCompTwo);
        mCompManager.addComponent(mockCompThree);
        assertEquals(mCompManager.getComponents().size(), 3);
    }

    @Test(expected=UnsupportedOperationException.class)
    public void componentsProtection() {
        MockCompodroidComponent mockCompOne = new MockCompodroidComponent();
        MockCompodroidComponent mockCompTwo = new MockCompodroidComponent();
        MockCompodroidComponent mockCompThree = new MockCompodroidComponent();
        mCompManager.addComponent(mockCompOne);
        mCompManager.addComponent(mockCompTwo);
        mCompManager.addComponent(mockCompThree);

        //exception is expected
        mCompManager.getComponents().remove(mockCompOne);
    }

    @Test(expected=IllegalArgumentException.class)
    public void nullArguments() {
        //exception is expected
        mCompManager.addComponent(null);
    }

    private static class MockCompodroidComponent extends CompodroidComponent<Object> {
        private boolean added;
        private int delegateCalledCount;

        @Override
        protected void onAddedToManager() {
            setAdded(true);
        }

        public void delegateMethod(){
            delegateCalledCount++;
        }

        public int getDelegateCalledCount() {
            return delegateCalledCount;
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
