package com.zasko.zffmpeg.sureface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;

import com.zasko.zffmpeg.R;


public class SurfaceViewActivity extends AppCompatActivity {


    private MSurfaceView mSurfaceView;

    private MGLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_layout);

//        mSurfaceView = findViewById(R.id.surface_view);


        mGLSurfaceView = (MGLSurfaceView) findViewById(R.id.gl_surface_view);

        findViewById(R.id.request_render_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGLSurfaceView.requestRender();
            }
        });
    }

}
