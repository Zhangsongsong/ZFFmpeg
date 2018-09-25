package com.zasko.zffmpeg.sureface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private static final String TAG = "MSurfaceView";

    public MSurfaceView(Context context) {
        super(context);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private SurfaceHolder mHolder;

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        mPath = new Path();
    }

    private int testCount = 0;


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        testCount++;

        Log.d(TAG, "surfaceCreated: --->" + testCount);

        isDrawing = true;

        if (mDrawThread == null) {
            mDrawThread = new Thread(this);
            mPath.moveTo(0, 400);
            mDrawThread.start();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged: ---->" + format + "\t" + width + "\t" + height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        Log.d(TAG, "surfaceDestroyed: ----->");
        isDrawing = false;
        mDrawThread = null;

    }

    private boolean isDrawing = false;
    private Thread mDrawThread;

    private Canvas mCanvas;
    private Paint mPaint;
    private Path mPath;

    private float mX = 0;
    private float mY = 0;
    private long mSleepTime = 0;

    @Override
    public void run() {
        while (isDrawing) {

            try {


                mCanvas = mHolder.lockCanvas();
                mCanvas.drawColor(Color.WHITE);
                mCanvas.drawPath(mPath, mPaint);

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (mCanvas != null) {
                    mHolder.unlockCanvasAndPost(mCanvas);
                }
            }


            mX += 1;
            mY = (int) (100 * Math.sin(mX * 2 * Math.PI / 180) + 400);
            mPath.lineTo(mX, mY);

            long time = System.currentTimeMillis();
            if (time - mSleepTime <= 15) {
                try {
                    Thread.sleep(15 - (time - mSleepTime));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                mSleepTime = time;
            }

        }
    }
}
