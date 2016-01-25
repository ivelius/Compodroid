package com.yan.compodroidtest.activities;

import com.yan.compodroid.activity.CompodroidActivityComponentsManager;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.injectionspack.ComponentFactoryInjectionsPack;
import com.yan.compodroid.injectionspack.components.saveinstancestate.SaveInstanceState;
import com.yan.compodroid.injectionspack.components.viewinjections.InjectView;
import com.yan.compodroid.injectionspack.components.viewinjections.InjectViewComponent;
import com.yan.compodroidtest.R;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;



public class InjectionsFirstActivity extends AppCompatActivity {


    private final CompodroidActivityComponentsManager mComponentsManager;
    @SaveInstanceState
    private boolean mSaved;

    @InjectView(R.id.text_view)
    private TextView mTextView;


    public InjectionsFirstActivity() {
        mComponentsManager = Compodroid.createActivityComponentManager(this);
        mComponentsManager.addComponent(ComponentFactoryInjectionsPack.createInjectViewActivityComponent());
        mComponentsManager.addComponent(ComponentFactoryInjectionsPack.createSaveInstanceStateActivityComponent());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mComponentsManager.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            mSaved = !mSaved;
            mTextView.setText("Value is : " + mSaved);
        });

        fab.show();
        mTextView.setText("Value is : " + mSaved);
        mTextView.setOnClickListener(v -> startActivity(InjectionsSecondActivity.createIntent(this, mSaved)));

    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        mComponentsManager.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}