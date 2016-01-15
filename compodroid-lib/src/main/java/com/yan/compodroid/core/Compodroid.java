package com.yan.compodroid.core;

import com.yan.compodroid.core.activity.CompodroidActivityComponentsManager;
import com.yan.compodroid.core.fragment.CompodroidFragmentComponentsManager;

import android.app.Activity;
import android.app.Fragment;


/**
 * Created by Yan-Home on 5/10/2015.
 */
public class Compodroid {

    /**
     * Creates a component manager that operates on Activity , as long as Activity is alive.
     *
     * @param activity activity that components operate on
     * @param <A>      Target type
     * @return new instance of {@link CompodroidActivityComponentsManager}
     */
    public static <A extends Activity> CompodroidActivityComponentsManager createActivityComponentManager(final A activity) {
        return new CompodroidActivityComponentsManager(activity);
    }

    /**
     * Creates a component manager that operates on Fragment , as long as Fragment is alive.
     *
     * @param fragment Fragment that components operate on
     * @param <F>      Target type
     * @return new instance of {@link CompodroidFragmentComponentsManager}
     */
    public static <F extends Fragment> CompodroidFragmentComponentsManager createFragmentComponentManager(final F fragment) {
        return new CompodroidFragmentComponentsManager(fragment);
    }

    /**
     * Creates a generic component manager that operates on target.
     *
     * @param <T>      Target type
     * @param target target object
     * @return new instance of {@link CompodroidComponentManager}
     */
    public static <T> CompodroidComponentManager<T,CompodroidComponent<T>> createGenericComponentManager(final T target) {
        return new CompodroidComponentManager(target);
    }

    /**
     * For future adaptations of one component into another , consider using this example
     */
//    public static void exampleOfComponentAdaptation() {
//        CompodroidComponent<MagazineOverviewFragment> sc = null;
//        CompodroidActivityComponent<ProductDetailActivity> ta =
//                new CompodroidActivityComponentAdapter<MagazineOverviewFragment, ProductDetailActivity>(sc) {
//                    @Override
//                    public CompodroidActivityComponent<ProductDetailActivity> adapt() {
//                        return new CompodroidActivityComponent<ProductDetailActivity>() {
//                            @Override
//                            public void onCreate(Bundle savedInstanceState) {
//                                super.onCreate(savedInstanceState);
//                                //TODO : some adaptation ...
//                            }
//                        };
//                    }
//                }.adapt();
//    }
}