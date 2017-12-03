package edu.pocketmoneymanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import edu.pocketmoneymanager.fragment.AddDataFragment;
import edu.pocketmoneymanager.fragment.DashboardViewFragment;

/**
 * Created by Ankit on 02/12/17.
 */

public class DashboardAdapter extends FragmentStatePagerAdapter {

    public DashboardAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new DashboardViewFragment();
                break;
            case 1:
                fragment = new AddDataFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Expenses";
            case 1:
                return "Add Data";
            default:
                return null;
        }
    }


}
