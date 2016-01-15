package com.yan.compodroidtest;

import com.yan.compodroidtest.activities.InjectionsFirstActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<String, Class<? extends Activity>> mTestStudyMap;

    public MainActivity() {
        mTestStudyMap = new HashMap<>();
        mTestStudyMap.put("Injection Pack Test", InjectionsFirstActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.case_study_list_view);
        String[] data = mTestStudyMap.keySet().toArray(new String[mTestStudyMap.size()]);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
        lv.setOnItemClickListener((parent, view, position, id) -> {
            TextView tv = (TextView) view;
            startActivity(new Intent(this, mTestStudyMap.get(tv.getText())));
        });

    }
}