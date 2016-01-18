package com.yan.compodroid.injectionspack;

import com.yan.compodroid.activity.CompodroidActivityComponentsManager;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.injectionspack.components.bundleextra.InjectBundleExtra;

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
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * We verify that bundle extra annotation is really working and injects
 * the extras provided in the intent that is used to create an activity
 */
public class BundleExtraComponentTest {

    public static final String EXTRA_KEY = "extra_key";
    public static final String EXTRA_VALUE = "extra value";

    @Mock()
    private TestActivity mMockTestActivity;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        Bundle bundle = mock(Bundle.class);
        when(bundle.getSerializable(EXTRA_KEY)).thenReturn(EXTRA_VALUE);

        Intent intent = mock(Intent.class);
        when(mMockTestActivity.getIntent()).thenReturn(intent);
        when(intent.getExtras()).thenReturn(bundle);

        doCallRealMethod().when(mMockTestActivity).onCreate(null);
        doCallRealMethod().when(mMockTestActivity).initComponentManager();
        doCallRealMethod().when(mMockTestActivity).getBundleExtraMember();
        mMockTestActivity.initComponentManager();
    }

    @Test
    public void verifyExtraKeyIsInjected() throws Exception {
        assertNull(mMockTestActivity.getBundleExtraMember());
        mMockTestActivity.onCreate(null);
        assertNotNull(mMockTestActivity.getBundleExtraMember());
        assertEquals(mMockTestActivity.getBundleExtraMember(),EXTRA_VALUE);
    }

    public static class TestActivity extends Activity{

        @InjectBundleExtra(EXTRA_KEY)
        private String mBundleExtraMember;

        private CompodroidActivityComponentsManager mCompManager;

        public void initComponentManager(){
            mCompManager = Compodroid.createActivityComponentManager(this);
            mCompManager.addComponent(ComponentFactoryInjectionsPack.createInjectBundleExtraActivityComponent());
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            mCompManager.onCreate(savedInstanceState);
        }

        public String getBundleExtraMember() {
            return mBundleExtraMember;
        }
    }
}