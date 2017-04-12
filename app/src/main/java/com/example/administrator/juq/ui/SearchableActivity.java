package com.example.administrator.juq.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.juq.R;

/**
 * Created by Administrator on 2017/4/5.
 */

public class SearchableActivity extends ListView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchable);
    }
    public SearchableActivity(Context context) {
        super(context);
    }
}
