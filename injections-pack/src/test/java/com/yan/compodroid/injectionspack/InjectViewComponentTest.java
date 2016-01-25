package com.yan.compodroid.injectionspack;

import com.yan.compodroid.activity.CompodroidActivityComponentsManager;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.injectionspack.components.viewinjections.InjectView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * We verify that save instance state component inject correct values into
 * annotated members.
 */
public class InjectViewComponentTest {

    private static final int MOCK_VIEW_ID = 57643579;

    @Mock
    private TestActivity mMockTestActivity;
    @Mock
    private View mMockDecorView;
    @Mock
    private View mMockInjectedView;
    @Mock
    private Window mMockWindow;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        doCallRealMethod().when(mMockTestActivity).onCreate(any(Bundle.class));
        doCallRealMethod().when(mMockTestActivity).initComponentManager();
        doCallRealMethod().when(mMockTestActivity).getView();
        when(mMockTestActivity.getWindow()).thenReturn(mMockWindow);
        when(mMockWindow.getDecorView()).thenReturn(mMockDecorView);
        when(mMockDecorView.findViewById(MOCK_VIEW_ID)).thenReturn(mMockInjectedView);
        when(mMockInjectedView.getId()).thenReturn(MOCK_VIEW_ID);
        mMockTestActivity.initComponentManager();
        mMockTestActivity.onCreate(null);
    }

    @Test
    public void verifySaveInstanceStateIsInjected() throws Exception {
        assertNotNull(mMockTestActivity.getView());
        assertEquals(mMockTestActivity.getView().getId(),MOCK_VIEW_ID);
    }

    public static class TestActivity extends Activity{

        @InjectView(MOCK_VIEW_ID)
        private View mView;
        private CompodroidActivityComponentsManager mCompManager;

        public void initComponentManager(){
            mCompManager = Compodroid.createActivityComponentManager(this);
            mCompManager.addComponent(ComponentFactoryInjectionsPack
                    .createInjectViewActivityComponent());
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            mCompManager.onCreate(savedInstanceState);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            mCompManager.onSaveInstanceState(outState);
        }

        public View getView() {
            return mView;
        }
    }
}