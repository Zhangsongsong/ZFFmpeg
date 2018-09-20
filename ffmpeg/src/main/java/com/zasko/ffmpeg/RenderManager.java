package com.zasko.ffmpeg;

public class RenderManager {


    static {
        System.loadLibrary("render-lib");
    }

    public static native String getConfig();

}