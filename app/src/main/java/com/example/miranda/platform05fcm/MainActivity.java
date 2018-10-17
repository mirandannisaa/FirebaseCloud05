package com.example.miranda.platform05fcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String tittle;
    public static String body;

    public TextView tvTittle, tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTittle = (TextView)findViewById(R.id.tvTittle);
        tvBody = (TextView)findViewById(R.id.tvBody);

        if(tittle!=null || body!=null){
            tvTittle.setText(tittle);
            tvBody.setText(body);
        }
    }
}
