package com.kevin.dianping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.btn_test_xutils)
    private Button btn_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载xUtils
        x.view().inject(this);
    }
    @Event(value = R.id.btn_test_xutils)
    private void Cilck(View view){
        switch (view.getId()){
            case R.id.btn_test_xutils:
                Toast.makeText(this,"xUtil测试",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
