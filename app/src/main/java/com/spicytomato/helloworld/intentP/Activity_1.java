package com.spicytomato.helloworld.intentP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.spicytomato.helloworld.R;

import static android.content.ContentValues.TAG;

public class Activity_1 extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_1_activity);

        mTextView = findViewById(R.id.text_1);
        Button button = findViewById(R.id.bt_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_1.this, Activity_2.class);
                intent.putExtra("name", "wyd");
                startActivityForResult(intent, 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String stirng = data.getStringExtra("result");

        if (requestCode == 0 && resultCode == 0) {
            Log.d("TAG", stirng);
            mTextView.setText("收到回传数据" + stirng);
        }
    }
}
