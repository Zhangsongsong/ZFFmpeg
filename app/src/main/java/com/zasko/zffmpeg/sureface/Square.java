package com.zasko.zffmpeg.sureface;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * @author Zasko
 * @date 2018/9/28
 */
public class Square {


    //绘制坐标
    public static final float[] squareCoords = {
            -0.5f, 0.5f, 0.0f,
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.5f, 0.5f, 0.0f
    };
    //绘制的顺序
    public static final short drawOrder[] = {0, 1, 2, 0, 2, 3};

    private final int mProgram;
    private FloatBuffer vertexBuffer;
    private ShortBuffer orderBuffer;

    public Square() {
        mProgram = GLES20.glCreateProgram();

        //转换成小端
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(squareCoords.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(squareCoords);
        vertexBuffer.position(0);

        ByteBuffer orBuffer = ByteBuffer.allocateDirect(drawOrder.length * 2);
        orBuffer.order(ByteOrder.nativeOrder());
        orderBuffer = orBuffer.asShortBuffer();
        orderBuffer.put(orderBuffer);
        orderBuffer.position(0);
    }

    public void draw() {



    }
}
