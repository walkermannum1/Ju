package com.example.administrator.juq.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;

import com.example.administrator.juq.R;

import java.io.LineNumberReader;

/**
 * Created by Administrator on 2017/4/13.
 */

public class FindAcitivity extends AppCompatActivity {

    private TabLayout mTableLayout;
    private Toolbar mToolbar;
    private String[] TITLE = {"推荐", "房源", "体验", "攻略"};
    private CollapsingToolbarLayout mToolbarLayout;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayoutState mLayoutState = CollapsingToolbarLayoutState.EXPANDED;
    private LinearLayout mLlContent;
    private LinearLayout mLlTitle;
    private AnimationSet mHideSet;
    private AnimationSet mShowSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
    }

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDSTATE
    }

}
