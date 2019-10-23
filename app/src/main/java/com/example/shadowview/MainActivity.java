package com.example.shadowview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shadowview.layout.QMUILinearLayout;
import com.example.shadowview.util.QMUIDisplayHelper;

public class MainActivity extends AppCompatActivity {
    QMUILinearLayout mTestLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTestLayout = findViewById(R.id.shadow);

        mTestLayout.setShadowColor(0xff0000ff);
        mTestLayout.setRadiusAndShadow(20,
                20,
                0.4f);
    }
}
