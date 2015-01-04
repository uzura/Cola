package net.jp.uzura.cola;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class WelcomeFragmentPagerAdapter extends FragmentPagerAdapter {

    public WelcomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Welcome1Fragment();
            case 1:
                return new Welcome2Fragment();
            case 2:
                return new Welcome3Fragment();
            case 3:
                return new Welcome4Fragment();
            default:
                return new Welcome1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position+1);
    }
}
