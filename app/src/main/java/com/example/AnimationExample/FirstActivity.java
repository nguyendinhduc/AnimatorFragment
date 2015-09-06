package com.example.AnimationExample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class FirstActivity extends Activity {
    private static final String TAG = "FirstActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        RelativeLayout click = (RelativeLayout) findViewById(R.id.click_layout);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bmp = getBitmap();

//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("picture", byteArray);
                ((MyApplication)getApplication()).setBmActivity(bmp);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

    public void click ( View view ) {
        Log.i(TAG, "onclick");
    }

    private Bitmap getBitmap(){
        View root = ((Activity)(this)).getWindow().getDecorView().findViewById(android.R.id.content);
        root.setDrawingCacheEnabled(true);
        return root.getDrawingCache();
    }
}
