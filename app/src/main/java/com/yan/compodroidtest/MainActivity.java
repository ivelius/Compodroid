package com.yan.compodroidtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yan.compodroid.core.CompodroidSystemsManager;
import com.yan.compodroid.systems.SaveInstanceSystem;
import com.yan.compodroid.systems.ViewInjectionSystem;

public class MainActivity extends AppCompatActivity implements ViewInjectionSystem.RootViewProvider {

    private final CompodroidSystemsManager mSystemsHost;

    @SaveInstanceSystem.SaveInstanceState
    private boolean mSaved;

    @ViewInjectionSystem.InjectView(R.id.text_view)
    private TextView mTextView;

    public MainActivity() {
        mSystemsHost = new CompodroidSystemsManager();
        mSystemsHost.addSystem(new ViewInjectionSystem(this, this));
        mSystemsHost.addSystem(new SaveInstanceSystem(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSystemsHost.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            mSaved = !mSaved;
            mTextView.setText("Value is : " + mSaved);
        });

        fab.show();
        mTextView.setText("Value is : " + mSaved);

    }


    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        mSystemsHost.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View provideRootView() {
        return getWindow().getDecorView();
    }
}