package edu.pocketmoneymanager.util;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import edu.pocketmoneymanager.dao.ExpensesDao;
import edu.pocketmoneymanager.model.ExpenseModel;

/**
 * Created by Ankit on 04/12/17.
 */

@Database(entities = {ExpenseModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "borrow_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract ExpensesDao itemAndPersonModel();

}
