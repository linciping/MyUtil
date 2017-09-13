package com.linciping.myutil;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.linciping.library.util.FileUtil;
import com.linciping.library.exception.CreateFileException;
import com.linciping.library.exception.PermissionException;
import com.linciping.library.exception.SDCardNoFoundException;
import com.linciping.library.util.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    private TextView txtInfo;

    private static final int READ_EXTERNAL_CODE = 10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo = (TextView) findViewById(R.id.txt_info);
        if (PermissionUtil.checkPermission(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA})){
            txtInfo.setText("权限申请成功");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PermissionUtil.onPermissionResult(requestCode,grantResults)){
            txtInfo.setText("权限申请成功");
        }
        else {
            txtInfo.setText("权限申请失败");
        }
    }
}
