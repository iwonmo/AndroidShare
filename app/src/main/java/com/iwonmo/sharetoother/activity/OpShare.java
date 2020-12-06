package com.iwonmo.sharetoother.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.Set;
import android.database.Cursor;
import android.provider.MediaStore;
import android.os.Build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class OpShare extends Activity
{

    public final void installApk()
    {
        Intent localIntent = getIntent();
        String str = localIntent.getType();
        Object localObject = str;
        if (str == null)
            localObject = "*/*";
        if (!localIntent.hasExtra("android.intent.extra.STREAM"))
        {
            Toast.makeText(this, "没有获取到数据", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType((Uri)localIntent.getExtras().get("android.intent.extra.STREAM"), "application/vnd.android.package-archive");
        }else {
            intent.addCategory("android.intent.category.DEFAULT")
                    .setDataAndType((Uri) localIntent.getExtras().get("android.intent.extra.STREAM"), (String) localObject);
        }
        startActivityForResult(intent, (int)System.currentTimeMillis());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        finish();
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        try
        {
            installApk();
            return;
        }
        catch (Exception paramBundles)
        {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramBundles);
            localStringBuilder.append("");
            Toast.makeText(this, localStringBuilder.toString(), 1).show();
            finish();
        }
    }
}
