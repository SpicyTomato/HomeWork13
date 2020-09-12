package com.spicytomato.helloworld.homework_4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.spicytomato.helloworld.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Permission;

public class Phone_Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_layout);


        Button button = findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(Phone_Activity.this, Manifest.permission.CALL_PHONE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(Phone_Activity.this, "缺少打电话的权限", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(Phone_Activity.this,new  String[]{Manifest.permission.CALL_PHONE},0x123);
                        return;
                    }
                }

                String number = "17610831397";
                String phoneNumber = null;

                try {
                    phoneNumber = URLEncoder.encode(number, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber)));


            }
        });


    }
}
