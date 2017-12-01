package edu.pocketmoneymanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.pocketmoneymanager.R;

/**
 * Created by Ankit on 02/12/17.
 */

public class DashboardViewFragment extends android.support.v4.app.Fragment {

    public DashboardViewFragment() {
        //Default Constructor

    }

    private View parentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.dashboard_view_fragment, container, false);
        return parentView;
    }
}
