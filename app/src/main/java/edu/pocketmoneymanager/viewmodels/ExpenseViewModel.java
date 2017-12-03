package edu.pocketmoneymanager.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import edu.pocketmoneymanager.model.ExpenseModel;
import edu.pocketmoneymanager.util.AppDatabase;

/**
 * Created by Ankit on 04/12/17.
 */

public class ExpenseViewModel extends AndroidViewModel {

    private final LiveData<List<ExpenseModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    public ExpenseViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllExpenses();
    }


    public LiveData<List<ExpenseModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    public void deleteItem(ExpenseModel borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<ExpenseModel, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final ExpenseModel... params) {
            db.itemAndPersonModel().deleteBorrow(params[0]);
            return null;
        }

    }

}