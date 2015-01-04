package net.jp.uzura.cola;

import com.crittercism.app.Crittercism;
import com.viewpagerindicator.CirclePageIndicator;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crittercism
        Crittercism.initialize(getApplicationContext(), getString(R.string.crittercism_app_id)); //Crittercism App ID

        setContentView(R.layout.activity_main);

        // ViewPager with fragment
        FragmentManager manager = getSupportFragmentManager();
        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final WelcomeFragmentPagerAdapter adapter = new WelcomeFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);

        //CirclePageIndicator
        CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);
    }
}
