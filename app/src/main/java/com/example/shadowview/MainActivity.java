package com.example.shadowview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lwx.shadowlibrary.layout.QMUILinearLayout;
import com.lwx.shadowlibrary.util.QMUIDisplayHelper;
import com.lwx.shadowlibrary.util.QMUILayoutHelper;

public class MainActivity extends AppCompatActivity {
    private QMUILinearLayout mTestLayout;
    private SeekBar testSeekbarAlpha;
    private SeekBar testSeekbarElevation;
    private Button shadowColorRed;
    private Button shadowColorBlue;
    private RadioGroup hideRadiusGroup;
    private TextView mAlphaTv;
    private TextView mElevationTv;


    private float mShadowAlpha = 0.25f;
    private int mShadowElevationDp = 14;
    private int mRadius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadius = QMUIDisplayHelper.dp2px(this, 15);

        initView();
        initListener();
    }

    private void initView() {
        mTestLayout = (QMUILinearLayout) findViewById(R.id.layout_for_test);
        mAlphaTv = (TextView) findViewById(R.id.alpha_tv);
        mElevationTv = (TextView) findViewById(R.id.elevation_tv);
        testSeekbarAlpha = (SeekBar) findViewById(R.id.test_seekbar_alpha);
        testSeekbarElevation = (SeekBar) findViewById(R.id.test_seekbar_elevation);
        shadowColorRed = (Button) findViewById(R.id.shadow_color_red);
        shadowColorBlue = (Button) findViewById(R.id.shadow_color_blue);
        hideRadiusGroup = (RadioGroup) findViewById(R.id.hide_radius_group);

        testSeekbarAlpha.setProgress((int) (mShadowAlpha * 100));
        testSeekbarElevation.setProgress(mShadowElevationDp);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MainActivity.this, mShadowElevationDp),
                mShadowAlpha);
        mTestLayout.setShadowColor(0xffffff00);
    }

    private void initListener() {
        shadowColorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTestLayout.setShadowColor(0xffff0000);
            }
        });
        shadowColorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTestLayout.setShadowColor(0xff0000ff);
            }
        });
        testSeekbarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mShadowAlpha = progress * 1f / 100;
                mAlphaTv.setText("alpha: " + mShadowAlpha);
                mTestLayout.setRadiusAndShadow(mRadius,
                        QMUIDisplayHelper.dp2px(MainActivity.this, mShadowElevationDp),
                        mShadowAlpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        testSeekbarElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mShadowElevationDp = progress;
                mElevationTv.setText("elevation: " + progress + "dp");
                mTestLayout.setRadiusAndShadow(mRadius,
                        QMUIDisplayHelper.dp2px(MainActivity.this, mShadowElevationDp), mShadowAlpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        hideRadiusGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.hide_radius_none:
                        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE);
                        break;
                    case R.id.hide_radius_left:
                        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_LEFT);
                        break;
                    case R.id.hide_radius_top:
                        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_TOP);
                        break;
                    case R.id.hide_radius_bottom:
                        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_BOTTOM);
                        break;
                    case R.id.hide_radius_right:
                        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_RIGHT);
                        break;
                }
            }
        });
    }
}
