package com.iwonmo.sharetoother.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OpView extends Activity
{
    public final void a()
    {
        Intent localIntent = getIntent();
        String str2 = localIntent.getType();
        String str1 = str2;
        if (str2 == null)
            str1 = "*/*";
        startActivityForResult(Intent.createChooser(new Intent("android.intent.action.SEND").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setType(str1).addCategory("android.intent.category.DEFAULT").putExtra("android.intent.extra.STREAM", localIntent.getData()), null), (int)System.currentTimeMillis());
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
            a();
            return;
        }
        catch (Exception paramBundles)
        {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramBundles);
            localStringBuilder.append("");
            Toast.makeText(this, localStringBuilder.toString(), Toast.LENGTH_LONG).show();
            finish();
        }
    }
}