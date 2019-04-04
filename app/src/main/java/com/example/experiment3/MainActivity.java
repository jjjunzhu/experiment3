package com.example.experiment3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mian_textview;
    private android.widget.Button Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Button button_acti = (Button) findViewById(R.id.button_acti);
        mian_textview = (TextView) findViewById(R.id.text1);
        button_acti.setOnClickListener(this);

        Button button_cryp_in = (Button)findViewById(R.id.button_cryp_in);
        button_cryp_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mian_textview.setText("点击了匿名内部类监听器");
                //事件处理
            }
        });

        Button button_inner = (Button)findViewById(R.id.button_inner);
        MyButtonlistener listener = new MyButtonlistener();
        button_inner.setOnClickListener(listener);

        Button button_outer = (Button)findViewById(R.id.button_outer);
        MyButtonlistener_out listener_out = new MyButtonlistener_out();
        button_outer.setOnClickListener(listener_out);

        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfigurationTest.class);
                startActivity(intent);
            }
        });

        Button button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgressDialogTest.class);
                startActivity(intent);
            }
        });
    }
    class MyButtonlistener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mian_textview.setText("点击了内部类监听器");
            //相关事件处理
        }
    }

    @Override
    public void onClick(View v) {
        mian_textview.setText("点击了activity作为监听器");
        //事件处理
    }
    public void newbutton(View v){
        mian_textview.setText("点击了绑定到标签监听器");
    }
    public class MyButtonlistener_out implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mian_textview.setText("点击了外部类监听器");
            //事件处理
        }
    }
    @OnClick(R.id.button6)
    void butterClick(View view){
        mian_textview.setText("点击了ButterKnife绑定");
    }
}
