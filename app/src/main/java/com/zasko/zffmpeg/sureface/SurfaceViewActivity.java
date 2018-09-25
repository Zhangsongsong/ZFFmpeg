package com.zasko.zffmpeg.sureface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import com.zasko.zffmpeg.R;


public class SurfaceViewActivity extends AppCompatActivity {


    private MSurfaceView mSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_layout);

        mSurfaceView = (MSurfaceView) findViewById(R.id.surface_view);

    }
}
