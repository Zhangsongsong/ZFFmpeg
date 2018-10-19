//
// Created by zasko on 2018/9/17.
//

#include <jni.h>
#include <string>
#include <android/log.h>
//
#define LOG_TAG "zasko"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
//#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)


#ifdef __cplusplus
extern "C" {
#endif
#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"
#include <SLES/OpenSLES.h>


JNIEXPORT jstring
JNICALL
Java_com_zasko_ffmpeg_RenderManager_getConfig(JNIEnv *env, jclass type) {

    char info[10000] = {0};
    sprintf(info, "%s\n", avcodec_configuration());

    int a[4] = {1, 2, 3, 4};
    int *ptr1 = (int *) (&a + 1);

    LOGI("From JNi Test %d", a[0]);
    return env->NewStringUTF(info);
}

JNIEXPORT void
JNICALL
Java_com_zasko_ffmpeg_RenderManager_playFile(JNIEnv *env, jclass type, jstring filePath) {
    avformat_network_init();
    av_register_all();

    char input_str[500] = {0};
    sprintf(input_str, "%s", env->GetStringUTFChars(filePath, NULL));
    AVFormatContext *avFormatContext = avformat_alloc_context();
    //打开文件
    if (avformat_open_input(&avFormatContext, input_str, NULL, NULL) != 0) {

    }
    //查找文件的流信息
    if (avformat_find_stream_info(avFormatContext, NULL) < 0) {

    }
    int videoIndex = -1;
    int audioIndex = -1;
    for (int i = 0; i < avFormatContext->nb_streams; i++) {
        if (avFormatContext->streams[i]->codecpar->codec_type == AVMEDIA_TYPE_AUDIO) {
            videoIndex = i;
        } else if (avFormatContext->streams[i]) {}

    }
    if (videoIndex == -1) {

    }

    //打开音频解码流
    AVCodec *audioCodec;

    AVCodecContext *audioCCtx;
    audioCodec = avcodec_find_decoder(audioCCtx->codec_id);

//    AVCodecParameters *avCodecParameters = avFormatContext->streams[audioIndex]->codecpar;
//    audioCodec = avcodec_find_decoder(avCodecParameters->codec_id);

    if (!audioCodec) {


    }

    if (avcodec_open2(audioCCtx, audioCodec, NULL) < 0) {

    }
    int width = audioCCtx->width;
    int height = audioCCtx->height;


}

JNIEXPORT void
JNICALL Java_com_zasko_ffmpeg_RenderManager_pcm2Wav(JNIEnv *env, jclass type) {

    av_register_all();


}

};
