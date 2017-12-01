package edu.pocketmoneymanager.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import edu.pocketmoneymanager.BR;

/**
 * Created by Ankit on 02/12/17.
 */

public class Dashboard extends BaseObservable {

    private String Title;

    public Dashboard(String title) {
        Title = title;
    }

    @Bindable
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
        notifyPropertyChanged(BR.title);
    }
}
