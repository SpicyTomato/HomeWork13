package com.spicytomato.helloworld.homework_5;

import android.Manifest;
import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spicytomato.helloworld.R;
import com.spicytomato.helloworld.homework_4.Phone_Activity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferences_Activity extends Activity {

    private LiveData<List<Member>> mMembers;
    private List<Member> mMembers1;
    private ListViewAdapter mListViewAdapter;
    private RecyclerView mRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences_layout);

        initView();

        SharedPreferences sharedPreferences = getSharedPreferences("information",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","王钰栋");
        editor.putString("id","2017012320");
        editor.apply();

        TextView textViewName = findViewById(R.id.text_name);
        TextView textViewId = findViewById(R.id.text_id);

        String name = sharedPreferences.getString("name","wu");
        String id = sharedPreferences.getString("id","0");

        textViewName.setText(name);
        textViewId.setText(id);

        String information = name + id;

        String FILE_NAME = "information.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.write(information.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ContentResolver resolver  = getContentResolver();
//        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null);
//        while (cursor.moveToNext()){
//            String name_ = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//
//            String id_ = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//            Log.d("TAG", name_ + id_);
//
//            mMembers1.add(new Member(id_,name_));
//
//        }

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(SharedPreferences_Activity.this, Manifest.permission.READ_CONTACTS) !=
                    PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SharedPreferences_Activity.this, "缺少权限", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(SharedPreferences_Activity.this,new  String[]{Manifest.permission.READ_CONTACTS},0x123);
                return ;
            }else {
                getMembersList();
            }
        }else {
            getMembersList();
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
        mListViewAdapter.submitList(mMembers1);
        mListViewAdapter.notifyDataSetChanged();
    }

    private void getMembersList() {
        ContentResolver resolver  = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null);
        while (cursor.moveToNext()){
            String name_ = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            String id_ = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Log.d("TAG", name_ + id_);

            mMembers1.add(new Member(id_,name_));

        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.phonemember_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(SharedPreferences_Activity.this,RecyclerView.VERTICAL,false));
        mListViewAdapter = new ListViewAdapter();
        mRecyclerView.setAdapter(mListViewAdapter);

        mMembers1 = new ArrayList<>();

    }
}
