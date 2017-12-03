package edu.pocketmoneymanager.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import edu.pocketmoneymanager.util.DateConverter;

/**
 * Created by Ankit on 04/12/17.
 */

@Entity
public class ExpenseModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String details;
    private long money;
    @TypeConverters(DateConverter.class)
    private Date timestamp;
    private String add;


    public ExpenseModel(String details, long money, Date timestamp, String add) {
        this.details = details;
        this.money = money;
        this.timestamp = timestamp;
        this.add = add;

    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public long getMoney() {
        return money;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getAdd() {
        return add;
    }
}
