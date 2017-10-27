package com.example.administrator.datechangegroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DateChangeView ChangeView;
    Button GetState;
    RadioButton radioOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChangeView = (DateChangeView) findViewById(R.id.ChangeView);
        radioOne= (RadioButton) findViewById(R.id.radioOne);
        radioOne.setChecked(true);
        GetState = (Button) findViewById(R.id.GetState);
        initView();
        ChangeView.setListenerEnabled(true);//开启监听
        GetState.setOnClickListener(this);
    }

    public void initView() {//加载数据

    }

    @Override
    public void onClick(View v) {
        Log.e("dxq", ChangeView.getmDateChangeState() + "  ChangeView");
    }
}
