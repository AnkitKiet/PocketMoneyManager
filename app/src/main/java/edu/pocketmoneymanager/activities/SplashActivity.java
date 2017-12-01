package edu.pocketmoneymanager.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.databinding.ActivitySplashBinding;
import edu.pocketmoneymanager.databinding.Splash;

import static java.lang.Thread.sleep;

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        final Splash user = new Splash("Pocket Money\n Manager", "Your Personal Wallet Manager");
        binding.setSplash(user);


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    user.setTitle("Loading...");
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(openActivity(SplashActivity.this, DashboardActivity.class));
                }
            }
        });
        thread.start();

    }
}
