package edu.pocketmoneymanager.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import edu.pocketmoneymanager.model.ExpenseModel;
import edu.pocketmoneymanager.util.AppDatabase;

/**
 * Created by Ankit on 04/12/17.
 */

public class AddExpensesViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddExpensesViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addBorrow(final ExpenseModel borrowModel) {
        new addAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class addAsyncTask extends AsyncTask<ExpenseModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final ExpenseModel... params) {
            db.itemAndPersonModel().addBorrow(params[0]);
            return null;
        }

    }
}