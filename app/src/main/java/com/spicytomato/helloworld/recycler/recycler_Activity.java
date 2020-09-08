package com.spicytomato.helloworld.recycler;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spicytomato.helloworld.R;
import com.spicytomato.helloworld.intentP.Activity_1;

import java.util.ArrayList;
import java.util.List;

public class recycler_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_parctice);

        final List<Mess> messes = new ArrayList<>();
        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Button button = findViewById(R.id.button_send);
        final EditText editText = findViewById(R.id.editText_write);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(messes);
        recyclerView.setAdapter(viewpagerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = new String[]{"好的", "谢谢你", "你真是个好人呢", "你真的很不错"};
                Editable message = editText.getText();
                Mess mess = new Mess(message.toString(), "send");
                messes.add(mess);
                viewpagerAdapter.notifyItemInserted(messes.size() - 1);
//                recyclerView.scrollToPosition(messes.size() - 1);
                editText.setText("");
                Mess mess2 = new Mess(strings[((int)(Math.random() * 10)%4)], "get");
                messes.add(mess2);
                viewpagerAdapter.notifyItemInserted(messes.size() - 1);
                recyclerView.scrollToPosition(messes.size() - 1);
            }
        });
    }

}
