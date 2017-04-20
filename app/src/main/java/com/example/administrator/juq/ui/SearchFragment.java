package com.example.administrator.juq.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/4/20
 */

public class SearchFragment extends Fragment {
    private static SearchFragment fragment = null;
    public static Fragment newInstance() {
        if (fragment == null){
            synchronized (SearchFragment.class) {
                if (fragment == null){
                    fragment = new SearchFragment();
                }
            }
        }
        return fragment;
    }
}
