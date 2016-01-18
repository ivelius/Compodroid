package com.yan.compodroid.injectionspack;

import com.yan.compodroid.activity.CompodroidActivityComponentsManager;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.injectionspack.components.saveinstancestate.SaveInstanceState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * We verify that save instance state component inject correct values into
 * annotated members.
 */
public class SaveInstanceStateComponentTest {

    private static final String EXTRA_VALUE = "extra_value";

    @Mock
    private TestActivity mMockTestActivity;
    @Mock
    private Bundle mMockBundle;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        //TODO : consider using captors
        when(mMockBundle.getSerializable("mSaveInstanceStateMember")).thenReturn(EXTRA_VALUE);
        doNothing().when(mMockBundle).putSerializable(any(String.class), any(String.class));

        doCallRealMethod().when(mMockTestActivity).onCreate(any(Bundle.class));
        doCallRealMethod().when(mMockTestActivity).initComponentManager();
        doCallRealMethod().when(mMockTestActivity).onSaveInstanceState(mMockBundle);
        doCallRealMethod().when(mMockTestActivity).setSaveInstanceStateMember(EXTRA_VALUE);
        doCallRealMethod().when(mMockTestActivity).getSaveInstanceStateMember();
        mMockTestActivity.initComponentManager();
    }

    @Test
    public void verifySaveInstanceStateIsInjected() throws Exception {
        assertNull(mMockTestActivity.getSaveInstanceStateMember());
        mMockTestActivity.onSaveInstanceState(mMockBundle);
        mMockTestActivity.onCreate(mMockBundle);
        assertNotNull(mMockTestActivity.getSaveInstanceStateMember());
        assertEquals(mMockTestActivity.getSaveInstanceStateMember(),EXTRA_VALUE);
    }

    public static class TestActivity extends Activity{

        @SaveInstanceState
        private String mSaveInstanceStateMember;
        private CompodroidActivityComponentsManager mCompManager;

        public void initComponentManager(){
            mCompManager = Compodroid.createActivityComponentManager(this);
            mCompManager.addComponent(ComponentFactoryInjectionsPack
                    .createSaveInstanceStateActivityComponent());
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            mCompManager.onCreate(savedInstanceState);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            mCompManager.onSaveInstanceState(outState);
        }

        public String getSaveInstanceStateMember() {
            return mSaveInstanceStateMember;
        }

        public void setSaveInstanceStateMember(String saveInstanceStateMember) {
            mSaveInstanceStateMember = saveInstanceStateMember;
        }
    }
}