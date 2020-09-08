package com.spicytomato.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(textView.getText() + "点击了");
//            }
//        });
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("清空了");
//            }
//        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                /*
                    加载布局文件 实例化成view
                 */
                final View view  = LayoutInflater.from(MainActivity.this).inflate(R.layout.alterdialog_ui,null,false);

                builder.setTitle("自定义对话框")
                        .setView(view)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText editText_name = view.findViewById(R.id.editText_name);
                                EditText editText_password = view.findViewById(R.id.editText_password);
                                final Editable name = editText_name.getText();
                                final Editable password = editText_password.getText();
                                if (name.toString().equals("asd") && password.toString().equals("123")){
                                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        })
                        .create().show();

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //注册上下文菜单 例如挡在TextView时长按时弹出
    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);

    }

    //弹出式窗口
//    public void showPopop(){
//        PopupMenu popupMenu = new PopupMenu()
//    }

}
