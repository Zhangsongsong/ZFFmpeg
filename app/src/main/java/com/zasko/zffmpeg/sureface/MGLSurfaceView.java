package com.zasko.zffmpeg.sureface;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class MGLSurfaceView extends GLSurfaceView {


    public MGLSurfaceView(Context context) {
        super(context);

        init();
    }

    public MGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private MGLRender mRender;

    private void init() {

        setEGLContextClientVersion(2);

        mRender = new MGLRender();
        setRenderer(mRender);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

//        setEGLContextClientVersion(2);

    }

}
