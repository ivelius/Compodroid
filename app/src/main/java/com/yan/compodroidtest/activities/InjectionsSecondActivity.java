package com.yan.compodroidtest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yan.compodroidtest.R;
import com.example.yanbraslavski.compodroidinjectionspack.components.InjectBundleExtraComponent;
import com.example.yanbraslavski.compodroidinjectionspack.components.SaveInstanceComponent;
import com.example.yanbraslavski.compodroidinjectionspack.components.ViewInjectionComponent;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.core.activity.CompodroidActivityComponentsManager;

public class InjectionsSecondActivity extends AppCompatActivity implements ViewInjectionComponent.RootViewProvider {

    private static final String EXTRA_KEY = "extra_key";
    private final CompodroidActivityComponentsManager mComponentsManager;

    @ViewInjectionComponent.InjectView(R.id.text_view)
    private TextView mTextView;

    @InjectBundleExtraComponent.InjectBundleExtra(EXTRA_KEY)
    private boolean mState;

    public static Intent createIntent(final @NonNull Context ctx,
                                      final boolean state) {
        Intent intent = new Intent(ctx, InjectionsSecondActivity.class);
        intent.putExtra(EXTRA_KEY, state);
        return intent;
    }

    public InjectionsSecondActivity() {
        mComponentsManager = Compodroid.createActivityComponentManager(this);
        mComponentsManager.addComponent(new ViewInjectionComponent(this));
        mComponentsManager.addComponent(new SaveInstanceComponent());
        mComponentsManager.addComponent(new InjectBundleExtraComponent());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mComponentsManager.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mTextView.setText("the state is " + mState);
    }


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        mComponentsManager.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View provideRootView() {
        return getWindow().getDecorView();
    }
}
