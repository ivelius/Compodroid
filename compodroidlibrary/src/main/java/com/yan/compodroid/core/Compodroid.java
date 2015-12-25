package com.yan.compodroid.core;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.yan.compodroid.core.activity.CompodroidActivityComponentsManager;


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
    public static <A extends Activity> CompodroidActivityComponentsManager createActivityComponentManager(final @NonNull A activity) {
        return new CompodroidActivityComponentsManager(activity);
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