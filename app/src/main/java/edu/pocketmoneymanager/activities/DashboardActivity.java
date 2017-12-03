package edu.pocketmoneymanager.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.adapter.DashboardAdapter;
import edu.pocketmoneymanager.databinding.ActivityDashboardBinding;
import edu.pocketmoneymanager.databinding.Dashboard;

/**
 * Created by Ankit on 01/12/17.
 */

public class DashboardActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDashboardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        final Dashboard dashboard = new Dashboard("Dashboard");
        binding.setDashboard(dashboard);
        binding.executePendingBindings();
        Toolbar toolbar = binding.getRoot().findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = binding.getRoot().findViewById(R.id.tabLayout);
        viewPager = binding.getRoot().findViewById(R.id.viewpager);
        DashboardAdapter pagerAdapter = new DashboardAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }


}
