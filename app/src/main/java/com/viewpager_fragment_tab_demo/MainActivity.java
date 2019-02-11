package com.viewpager_fragment_tab_demo;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends ActionBarActivity implements
		android.support.v7.app.ActionBar.TabListener {
	ViewPager viewPager;

	// Using appcompat action bar
	private android.support.v7.app.ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// View pager for showing many fragments over a single activity
		viewPager = (ViewPager) findViewById(R.id.pager);

		// Getting fragment manager to control fragments
		FragmentManager fragmnetManager = getSupportFragmentManager();

		// Setting adapter over view pager
		viewPager.setAdapter(new MyAdapter(fragmnetManager));

		// Implementing view pager pagechangelistener to navigate between tabs
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int pos) {

				// Setting navigation of tabs to actionbar
				actionBar.setSelectedNavigationItem(pos);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		// Getting actionbar
		actionBar = getSupportActionBar();

		// Setting navigation mode to actionbar
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Now adding a new tab to action bar and setting title, icon and
		// implementing listener
		android.support.v7.app.ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("TAB1");
		// tab1.setIcon(R.drawable.ic_launcher);
		tab1.setTabListener(this);

		android.support.v7.app.ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("TAB2");
		tab2.setTabListener(this);

		android.support.v7.app.ActionBar.Tab tab3 = actionBar.newTab();
		tab3.setText("TAB3");
		tab3.setTabListener(this);

		// Now finally adding all tabs to actionbar
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

	}

	@Override
	public void onTabReselected(android.support.v7.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {

	}

	@Override
	public void onTabSelected(android.support.v7.app.ActionBar.Tab tab,
			FragmentTransaction arg1) {

		// Setting current position of tab to view pager
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(android.support.v7.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {

	}

}

// My adapter i.e. custom adapter for displaying fragments over view pager
class MyAdapter extends FragmentPagerAdapter {
	public MyAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int i) {

		// Getting fragments according to selected position
		Fragment fragment = null;
		if (i == 0) {
			fragment = new FragmentA();
		}
		if (i == 1) {
			fragment = new FragmentB();
		}
		if (i == 2) {
			fragment = new FragmentC();
		}

		// and finally returning fragments
		return fragment;
	}

	@Override
	public int getCount() {

		// Returning no. of counts of fragments
		return 3;
	}
}
