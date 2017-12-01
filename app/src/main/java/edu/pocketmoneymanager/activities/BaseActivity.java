package edu.pocketmoneymanager.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ankit on 01/12/17.
 */

public class BaseActivity extends AppCompatActivity {

    public Intent openActivity(Context first, Class<? extends AppCompatActivity> second) {

        Intent intent = new Intent(first, second);
        return intent;
    }
}
