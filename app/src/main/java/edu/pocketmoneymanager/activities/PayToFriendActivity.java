package edu.pocketmoneymanager.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.databinding.ActivityPayFriendBinding;
import edu.pocketmoneymanager.databinding.PayFriend;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Ankit on 23/12/17.
 */

public class PayToFriendActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private static final int PERMS_REQUEST_CODE = 140;
    private String[] Permissions = new String[]{
            Manifest.permission.CAMERA};
    private Boolean isCameraStarted = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPayFriendBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_pay_friend);
        final PayFriend payFirend = new PayFriend("Scan QR");
        binding.setPayfriend(payFirend);
        binding.executePendingBindings();
        Button btnPay = binding.getRoot().findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(PayToFriendActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    scan();
                } else {
                    ActivityCompat.requestPermissions(PayToFriendActivity.this, Permissions, PERMS_REQUEST_CODE);
                }
            }
        });
    }

    private void scan() {
        isCameraStarted = true;
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(this, "Result" + result.getText(), Toast.LENGTH_SHORT).show();

        //To be done
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isCameraStarted)
            mScannerView.stopCamera();
    }
}
