package com.yan.compodroid.injectionspack;

import com.yan.compodroid.activity.CompodroidActivityComponent;
import com.yan.compodroid.activity.CompodroidActivityComponentAdapter;
import com.yan.compodroid.fragment.CompodroidFragmentComponent;
import com.yan.compodroid.fragment.CompodroidFragmentComponentAdapter;
import com.yan.compodroid.injectionspack.components.bundleextra.InjectBundleExtraComponent;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by yan.braslavski on 1/17/16.
 */
public class ComponentFactoryInjectionsPack {

    /**
     * Annotate your class fields with {@link com.yan.compodroid.injectionspack.components.bundleextra.InjectBundleExtra}
     * in order to easily inject expected extra values that are delivered via intent to your Activity.
     *
     * Fileds injection takes place in "onCreate" method of the activity.
     * Make sure to add this component as early as possible in your {@link com.yan.compodroid.activity.CompodroidActivityComponentsManager}
     */
    public static CompodroidActivityComponent<Activity> createInjectBundleExtraActivityComponent() {
        return new CompodroidActivityComponentAdapter<InjectBundleExtraComponent, Activity>(new InjectBundleExtraComponent()) {
            @Override
            public CompodroidActivityComponent<Activity> adapt() {
                return new CompodroidActivityComponent<Activity>() {
                    @Override
                    public void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        //Here we adapt the component for any activity
                        if (getTarget().getIntent() == null || getTarget().getIntent().getExtras() == null)
                            return;

                        final Bundle extras = getTarget().getIntent().getExtras();
                        getAdaptee().injectBundleExtra(extras, getTarget());
                    }
                };
            }
        }.adapt();
    }

    /**
     * Annotate your class fields with {@link com.yan.compodroid.injectionspack.components.bundleextra.InjectBundleExtra}
     * in order to easily inject expected extra values that are delivered via arguments to your Fragment.
     *
     * Fileds injection takes place in "onCreate" method of the fragment.
     * Make sure to add this component as early as possible in your {@link com.yan.compodroid.fragment.CompodroidFragmentComponentsManager}
     */
    public static CompodroidFragmentComponent<Fragment> createInjectBundleExtraFragmentComponent() {
        return new CompodroidFragmentComponentAdapter<InjectBundleExtraComponent, Fragment>(new InjectBundleExtraComponent()) {
            @Override
            public CompodroidFragmentComponent<Fragment> adapt() {
                return new CompodroidFragmentComponent<Fragment>() {
                    @Override
                    public void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        //Here we adapt the component for any fragment
                        if (getTarget().getArguments() == null)
                            return;

                        final Bundle extras = getTarget().getArguments();
                        getAdaptee().injectBundleExtra(extras, getTarget());
                    }
                };
            }
        }.adapt();
    }
}