package edu.pocketmoneymanager.fragment;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.adapter.ExpenseViewAdapter;
import edu.pocketmoneymanager.model.ExpenseModel;
import edu.pocketmoneymanager.viewmodels.ExpenseViewModel;

/**
 * Created by Ankit on 02/12/17.
 */

public class DashboardViewFragment extends LifecycleFragment {

    public DashboardViewFragment() {
        //Default Constructor

    }

    private ExpenseViewAdapter expenseViewAdapter;
    private ExpenseViewModel expenseViewModel;
    private RecyclerView rvExpenses;
    private View parentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.dashboard_view_fragment, container, false);
        rvExpenses = (RecyclerView) parentView.findViewById(R.id.rvExpenses);
        populate();
        return parentView;
    }

    private void populate() {

        expenseViewAdapter = new ExpenseViewAdapter(getActivity(),new ArrayList<ExpenseModel>());
        rvExpenses.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvExpenses.setAdapter(expenseViewAdapter);
        expenseViewModel = ViewModelProviders.of(this).get(ExpenseViewModel.class);

        expenseViewModel.getItemAndPersonList().observe(getActivity(), new Observer<List<ExpenseModel>>() {
            @Override
            public void onChanged(@Nullable List<ExpenseModel> itemAndPeople) {
                expenseViewAdapter.addItems(itemAndPeople);
            }
        });

    }

}