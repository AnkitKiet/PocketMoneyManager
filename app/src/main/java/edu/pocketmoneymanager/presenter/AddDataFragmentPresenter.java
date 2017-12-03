package edu.pocketmoneymanager.presenter;

import android.content.Context;
import android.widget.Toast;

import edu.pocketmoneymanager.activities.BaseActivity;

/**
 * Created by Ankit on 03/12/17.
 */

public class AddDataFragmentPresenter {

    public void addData(Context context, long money, String details) {
        BaseActivity base = new BaseActivity();
        Long totalMoney = base.getTotalMoney(context);
        Toast.makeText(context, "Money=" + money + " details=" + details + " Total" + totalMoney, Toast.LENGTH_LONG).show();
        Long leftOver = totalMoney - money;
        Toast.makeText(context, "LeftMoney=" + leftOver + " details=" + details + " Total" + totalMoney, Toast.LENGTH_LONG).show();

    }


}

