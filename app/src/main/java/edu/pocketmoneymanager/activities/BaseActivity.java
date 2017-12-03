package edu.pocketmoneymanager.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ankit on 01/12/17.
 */

public class BaseActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public static final String MyPreference = "mTotalMoney";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(MyPreference, Context.MODE_PRIVATE);

    }

    public Intent openActivity(Context first, Class<? extends AppCompatActivity> second) {

        Intent intent = new Intent(first, second);
        return intent;
    }

    public void saveTotalMoney(Context context, long money) {
        sharedPreferences = context.getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong("mMoney", money);
        editor.apply();
    }

    public Long getTotalMoney(Context context) {
        sharedPreferences = context.getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
        Long value = sharedPreferences.getLong("mMoney", 0);
        return value;
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
    }
}
