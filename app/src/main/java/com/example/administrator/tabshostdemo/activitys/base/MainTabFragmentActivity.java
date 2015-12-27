package com.example.administrator.tabshostdemo.activitys.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.tabshostdemo.R;

import java.util.HashMap;
import java.util.Stack;

public class MainTabFragmentActivity extends AppCompatActivity {
    /* Your Tab host */
    private TabHost mTabHost;

    /* A HashMap of stacks, where we use tab identifier as keys..*/
    private HashMap<String, Stack<Fragment>> mStacks;

    /*Save current tabs identifier in this..*/
    private String mCurrentTab;

    private Toolbar mToolbar;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_fragment);
        setupToolbar();

        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
      //  mTabHost.setOnTabChangedListener(listener);
        mTabHost.setup();

        initializeTabs();
    }

    private void initializeTabs() {
            /* Setup your tab icons and content views.. Nothing special in this..*/
        TabHost.TabSpec spec = mTabHost.newTabSpec(AppConstants.TAB_A);
        mTabHost.setCurrentTab(-4);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_a_state_btn, "Contests"));
        mTabHost.addTab(spec);


        spec = mTabHost.newTabSpec(AppConstants.TAB_B);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_b_state_btn, "Group"));
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec(AppConstants.TAB_C);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_c_state_btn, "Profile"));
        mTabHost.addTab(spec);
    }
    private View createTabView(final int id, final String tabName) {
        View view = LayoutInflater.from(this).inflate(R.layout.tabs_icon, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        imageView.setImageDrawable(getResources().getDrawable(id));
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        textView.setText(tabName);
        return view;
    }

    private void setupToolbar() {

    }


}
