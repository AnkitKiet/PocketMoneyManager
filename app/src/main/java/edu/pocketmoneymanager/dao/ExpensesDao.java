package edu.pocketmoneymanager.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import edu.pocketmoneymanager.model.ExpenseModel;
import edu.pocketmoneymanager.util.DateConverter;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Ankit on 04/12/17.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface ExpensesDao {

    @Query("select * from ExpenseModel")
    LiveData<List<ExpenseModel>> getAllExpenses();

    @Query("select * from ExpenseModel where id = :id")
    ExpenseModel getItembyId(String id);

    @Insert(onConflict = REPLACE)
    void addBorrow(ExpenseModel borrowModel);

    @Delete
    void deleteBorrow(ExpenseModel borrowModel);


}
