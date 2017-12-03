package edu.pocketmoneymanager.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import edu.pocketmoneymanager.BR;

/**
 * Created by Ankit on 03/12/17.
 */

public class AddFragment extends BaseObservable {


    private String details;
    private long money;


    public AddFragment(String details, long money) {
        this.details = details;
        this.money = money;
    }

    @Bindable
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        notifyPropertyChanged(BR.details);
    }

    @Bindable
    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
        notifyPropertyChanged(BR.money);
    }
}
