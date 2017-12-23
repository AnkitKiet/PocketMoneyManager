package edu.pocketmoneymanager.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import edu.pocketmoneymanager.BR;


/**
 * Created by Ankit on 23/12/17.
 */

public class PayFriend extends BaseObservable {

    private String btnText;

    public PayFriend(String btnText) {
        this.btnText = btnText;
    }

    @Bindable
    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
        notifyPropertyChanged(BR.btnText);
    }
}
