package com.yan.compodroidtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yan.compodroidtest.compopack.components.SaveInstanceComponent;
import com.yan.compodroidtest.compopack.components.ViewInjectionComponent;
import com.yan.compodroid.core.Compodroid;
import com.yan.compodroid.core.activity.CompodroidActivityComponentsManager;

public class MainActivity extends AppCompatActivity implements ViewInjectionComponent.RootViewProvider {


    private final CompodroidActivityComponentsManager mComponentsManager;
    @SaveInstanceComponent.SaveInstanceState
    private boolean mSaved;

    @ViewInjectionComponent.InjectView(R.id.text_view)
    private TextView mTextView;


    public MainActivity() {
        mComponentsManager = Compodroid.createActivityComponentManager(this);
        mComponentsManager.addComponent(new ViewInjectionComponent(this));
        mComponentsManager.addComponent(new SaveInstanceComponent());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        mTextView.setOnClickListener(v -> startActivity(SecondActivity.createIntent(this, mSaved)));

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