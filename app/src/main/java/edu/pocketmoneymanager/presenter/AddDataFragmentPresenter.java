package edu.pocketmoneymanager.presenter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.util.Date;

import edu.pocketmoneymanager.activities.BaseActivity;
import edu.pocketmoneymanager.model.ExpenseModel;
import edu.pocketmoneymanager.viewmodels.AddExpensesViewModel;

/**
 * Created by Ankit on 03/12/17.
 */

public class AddDataFragmentPresenter {

    private AddExpensesViewModel addExpensesViewModel;
    Long leftOver;

    public void addData(Context context, long money, String details, Date date, Boolean chkAdd) {
        BaseActivity base = new BaseActivity();
        Long totalMoney = base.getTotalMoney(context);
        Toast.makeText(context, "Money=" + money + " details=" + details + " Total" + totalMoney, Toast.LENGTH_LONG).show();
        if (chkAdd) {
            leftOver = totalMoney + money;
            base.saveTotalMoney(context, leftOver);
        } else {
            leftOver = totalMoney - money;

        }

        Toast.makeText(context, "LeftMoney=" + leftOver + " details=" + details + " Total" + totalMoney, Toast.LENGTH_LONG).show();
        addExpensesViewModel = ViewModelProviders.of((FragmentActivity) context).get(AddExpensesViewModel.class);
        addExpensesViewModel.addBorrow(new ExpenseModel(details, money, date, chkAdd.toString()));
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        base.saveTotalMoney(context, leftOver);
    }


}

