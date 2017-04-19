package com.example.administrator.juq.ui;

import android.icu.math.MathContext;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.juq.R;

import java.io.LineNumberReader;

/**
 * Created by Administrator on 2017/4/13.
 */

public class FindActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private String[] TITLE = {"推荐", "房源", "体验", "攻略"};
    private CollapsingToolbarLayout mToolbarLayout;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayoutState mLayoutState = CollapsingToolbarLayoutState.EXPANDED;
    private LinearLayout mLlContent;
    private ImageView mIvArrow;
    private LinearLayout mLlTitle;
    private AnimationSet mHideSet;
    private AnimationSet mShowSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mLlContent = (LinearLayout) findViewById(R.id.ll_content);
        mIvArrow = (ImageView) findViewById(R.id.up_arrow);
        mLlTitle = (LinearLayout) findViewById(R.id.ll_title);
        initTabLayout();
        initData();
    }

    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setText(TITLE[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(TITLE[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(TITLE[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(TITLE[3]));
    }

    private void initData() {
        collapsingListener();
        showAnim();
        hideAnim();
    }

    private void collapsingListener() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0) {
                    if (mLayoutState != CollapsingToolbarLayoutState.EXPANDED) {
                        mLayoutState = CollapsingToolbarLayoutState.EXPANDED;
                        mLlTitle.setVisibility(View.GONE);
                        mIvArrow.setVisibility(View.VISIBLE);
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (mLayoutState != CollapsingToolbarLayoutState.COLLAPSED) {
                        mLlContent.startAnimation(mHideSet);
                        mLlContent.setVisibility(View.GONE);
                        mLlTitle.startAnimation(mShowSet);
                        mLlTitle.setVisibility(View.VISIBLE);
                        mLayoutState = CollapsingToolbarLayoutState.COLLAPSED;
                    }
                } else {
                    if (mLayoutState != CollapsingToolbarLayoutState.INTERNEDSTATE) {
                        if (mLayoutState == CollapsingToolbarLayoutState.COLLAPSED) {
                            mLlContent.startAnimation(mShowSet);
                            mLlContent.setVisibility(View.VISIBLE);
                            mLlTitle.startAnimation(mHideSet);
                            mLlTitle.setVisibility(View.GONE);
                        }
                        mLayoutState = CollapsingToolbarLayoutState.INTERNEDSTATE;
                    }
                }
            }
        });
    }


    private void hideAnim() {
        mHideSet = new AnimationSet(true);
        mHideSet.setInterpolator(new LinearInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        TranslateAnimation hidenAcrion = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f);
        mHideSet.addAnimation(alphaAnimation);
        mHideSet.addAnimation(hidenAcrion);
        mHideSet.setDuration(300);
    }

    private void showAnim() {
        mShowSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation showAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mShowSet.addAnimation(scaleAnimation);
        mShowSet.addAnimation(alphaAnimation);
        mShowSet.addAnimation(showAction);
        mShowSet.setDuration(500);
    }

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDSTATE
    }

}
