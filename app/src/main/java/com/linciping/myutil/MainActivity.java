package com.linciping.myutil;

import android.icu.util.MeasureUnit;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.linciping.library.FileController;
import com.linciping.library.FileUtil;

public class MainActivity extends AppCompatActivity {

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo= (TextView) findViewById(R.id.txt_info);
        FileUtil.getAppPath(this,new FileController() {
            @Override
            public void onPath(String path) {
                txtInfo.setText(path);
            }

            @Override
            public void onFailed(String message) {
                txtInfo.setText(message);
            }
        });
    }
}
