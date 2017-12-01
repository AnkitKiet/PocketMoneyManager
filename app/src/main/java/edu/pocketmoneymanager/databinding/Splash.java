package edu.pocketmoneymanager.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import edu.pocketmoneymanager.BR;


/**
 * Created by Ankit on 01/12/17.
 */

public class Splash extends BaseObservable {

    private String title;
    private String slogan;

    public Splash(String title, String slogan) {
        this.title = title;
        this.slogan = slogan;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getSlogan() {
        return slogan;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
        notifyPropertyChanged(BR.slogan);
    }
}
