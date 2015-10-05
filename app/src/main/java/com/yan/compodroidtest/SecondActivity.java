package com.yan.compodroidtest;

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

import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.core.CompodroidSystemsManager;
import com.yan.compodroid.systems.InjectBundleExtraSystem;
import com.yan.compodroid.systems.SaveInstanceSystem;
import com.yan.compodroid.systems.ViewInjectionSystem;

public class SecondActivity extends AppCompatActivity implements ViewInjectionSystem.RootViewProvider {

    private static final String EXTRA_KEY = "extra_key";
    private final CompodroidSystemsManager mSystemsManager;

    @ViewInjectionSystem.InjectView(R.id.text_view)
    private TextView mTextView;

    @InjectBundleExtraSystem.InjectBundleExtra(EXTRA_KEY)
    private boolean mState;

    public static Intent createIntent(final @NonNull Context ctx,
                                      final boolean state) {
        Intent intent = new Intent(ctx, SecondActivity.class);
        intent.putExtra(EXTRA_KEY, state);
        return intent;
    }

    public SecondActivity() {
        mSystemsManager = Compodroid.createSystemManager(this);
        mSystemsManager.addSystem(new ViewInjectionSystem(this));
        mSystemsManager.addSystem(new SaveInstanceSystem());
        mSystemsManager.addSystem(new InjectBundleExtraSystem());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSystemsManager.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mTextView.setText("the state is " + mState);
    }


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        mSystemsManager.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View provideRootView() {
        return getWindow().getDecorView();
    }
}
