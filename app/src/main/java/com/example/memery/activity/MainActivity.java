package com.example.memery.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.memery.LAdapter;

import top.niunaijun.blackboxa.R;
import top.niunaijun.blackboxa.view.main.WelcomeActivity;


public class MainActivity extends Activity  {
    Button bttest, button2, btim, add, dec;
    TextView txnum, textview3;
    GridView numshow;
    EditText ed, edim;
    int n = 1, jz = 10, time = 0;
    boolean test = true;
    Context c = this;
    String[] math;
    Handler uiHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1: {
                    textview3.setText(time + "s");
                    time++;
                    uiHandler.sendEmptyMessageDelayed(1, 1000);
                }
                break;

                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem);
        bttest = (Button) findViewById(R.id.bttest);
        button2 = (Button) findViewById(R.id.button2);
        btim = (Button) findViewById(R.id.btim);
        add = (Button) findViewById(R.id.btadd);
        dec = (Button) findViewById(R.id.btsub);
        numshow = (GridView) findViewById(R.id.gridView1);
        txnum = (TextView) findViewById(R.id.txnum);
        textview3 = (TextView) findViewById(R.id.textView3);
        ed = (EditText) findViewById(R.id.editText1);
        edim = (EditText) findViewById(R.id.edim);
        uiHandler.sendEmptyMessage(1);
        ed.setEnabled(false);
        numshow.setAdapter(new LAdapter(c, xh()));
        bttest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO 自动生成的方法存根
                ed.setEnabled(test);
                time = 0;
                String[] math0;
                if (test) {
                    math0 = new String[n];
                    for (int i = 0; i < n; i++) {
                        math0[i] = "";
                    }
                } else math0 = xh();
                numshow.setAdapter(new LAdapter(c, math0));
                test = test ? false : true;
            }
        });
        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                time = 0;
                if (jz == 10) {
                    jz = 2;
                    button2.setText("十进制");
                } else {
                    jz = 10;
                    button2.setText("二进制");
                }
                numshow.setAdapter(new LAdapter(c, xh()));
            }
        });


        numshow.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                    long arg3) {
                // TODO 自动生成的方法存根
                String s = ed.getText().toString();
                TextView t = (TextView) v;
                if (s.equals(math[arg2])) {
                    t.setBackgroundColor(Color.BLUE);
                    ed.setText("");
                } else {
                    t.setBackgroundColor(Color.RED);
                }
                t.setText(math[arg2]);
            }
        });
        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO 自动生成的方法存根

                n++;
                txnum.setText(4 * n + "个数字");
            }
        });
        dec.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO 自动生成的方法存根
                n--;
                txnum.setText(4 * n + "个数字");
            }
        });
        ed.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO 自动生成的方法存根
                ed.setText("");
            }
        });
        txnum.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }
        });

    }



    private String[] xh() {
        // TODO 自动生成的方法存根
        math = new String[n];
        int ms;
        for (int i = 0; i < n; i++) {
            math[i] = "";
            if (jz == 10) {
                ms = (int) (Math.random() * 9000 + 1000);
                math[i] += ms;
            } else {
                for (int j = 0; j < 6; j++) {
                    ms = (int) (Math.random() * 2);
                    math[i] += ms;
                }
            }
        }
        txnum.setText(4 * n + "个数字");
        return math;


    }






}
