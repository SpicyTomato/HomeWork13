package com.spicytomato.helloworld.intentP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.spicytomato.helloworld.R;

public class Activity_2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_2_activity);

        TextView textView = findViewById(R.id.text_2);
        Button button  = findViewById(R.id.bt_2);

        final Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        textView.setText("收到传输数据" + name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result","20");
                setResult(0,intent);
                finish();
            }
        });

    }

}
