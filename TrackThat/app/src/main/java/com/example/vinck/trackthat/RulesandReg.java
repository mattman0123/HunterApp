package com.example.vinck.trackthat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class RulesandReg extends AppCompatActivity {

    public String PDF_File_Name = NULL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rulesand_reg);
    }

    public void Open_Reg(View view){
        switch (view.getId()){
            case R.id.btnAlberta:
                PDF_File_Name = "Alb_Canada_2016.pdf";
                copyReadAssets();
                break;
            case R.id.btnMan:
                PDF_File_Name = "Man_Canada_2016.pdf";
                copyReadAssets();
                break;
            case R.id.btnSask:
                PDF_File_Name = "Sask_Canada_2016.pdf";
                copyReadAssets();
                break;
        }
    }
    private void copyReadAssets()
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;

        String strDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ File.separator + "Pdfs";
        File fileDir = new File(strDir);
        fileDir.mkdirs();
        File file = new File(fileDir, PDF_File_Name);



        try
        {

            in = assetManager.open(PDF_File_Name);
            out = new BufferedOutputStream(new FileOutputStream(file));


            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "Pdfs" + "/" + PDF_File_Name), "application/pdf");
        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
}
