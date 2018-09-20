//
// Created by zasko on 2018/9/17.
//

#include <jni.h>
#include <string>


#ifdef __cplusplus
extern "C" {
#endif
#include "libavcodec/avcodec.h"

JNIEXPORT jstring
JNICALL
Java_com_zasko_ffmpeg_RenderManager_getConfig(JNIEnv
                                              *env,
                                              jobject) {

    char info[10000] = {0};
    sprintf(info, "%s\n", avcodec_configuration());
    return env->NewStringUTF(info);

}


};