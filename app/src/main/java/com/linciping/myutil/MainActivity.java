package com.linciping.myutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.linciping.library.util.FileUtil;
import com.linciping.library.exception.CreateFileException;
import com.linciping.library.exception.PermissionException;
import com.linciping.library.exception.SDCardNoFoundException;

public class MainActivity extends AppCompatActivity {

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo= (TextView) findViewById(R.id.txt_info);
        try {
            String appPath=FileUtil.getAppPath(this);
            txtInfo.setText(appPath);
        } catch (SDCardNoFoundException | PermissionException | CreateFileException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
