//
// Created by zasko on 2018/10/12.
//

#include <jni.h>

#ifndef ZFFMPEG_ZPLAY_LIB_H
#define ZFFMPEG_ZPLAY_LIB_H

#endif //ZFFMPEG_ZPLAY_LIB_H

#ifdef  __cplusplus
extern "C" {
#endif


JNIEXPORT void
JNICALL Java_com_zasko_ffmpeg_RenderManager_pcm2Wav(JNIEnv *env, jclass type);

JNIEXPORT void
JNICALL
Java_com_zasko_ffmpeg_RenderManager_playFile(JNIEnv *env, jclass type, jstring filePath);

JNIEXPORT jstring
JNICALL
Java_com_zasko_ffmpeg_RenderManager_getConfig(JNIEnv *env, jclass type);


};
