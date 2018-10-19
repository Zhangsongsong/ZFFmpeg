 # For more information about using CMake with Android Studio, read the
 # documentation: https://d.android.com/studio/projects/add-native-code.html

 # Sets the minimum version of CMake required to build the native library.

 cmake_minimum_required(VERSION 3.4.1)

 set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})

 # Specifies a library name, specifies whether the library is STATIC or
 # SHARED, and provides relative paths to the source code. You can
 # define multiple libraries by adding multiple add.library() commands,
 # and CMake builds them for you. When you build your app, Gradle
 # automatically packages shared libraries with your APK.

 add_library( # Sets the name of the library.
         zplay-lib

         # Sets the library as a shared library.
         SHARED

         # Provides a relative path to your source file(s).
         ${CMAKE_SOURCE_DIR}/src/main/cpp/zplay-lib.cpp
         ${CMAKE_SOURCE_DIR}/src/main/cpp/pcm/ZPcm2wav.cpp)


 # Specifies libraries CMake should link to your target library. You
 # can link multiple libraries, such as libraries you define in this
 # build script, prebuilt third-party libraries, or system libraries.

 target_link_libraries( # Specifies the target library.
         zplay-lib

         # Links the target library to the log library
         # included in the NDK.
         android
         ${log-lib}

         libavcodec
         libavdevice
         libavfilter
         libavformat
         libavutil
         libswresample
         libswscale)


 # Searches for a specified prebuilt library and stores the path as a
 # variable. Because CMake includes system libraries in the search path by
 # default, you only need to specify the name of the public NDK library
 # you want to add. CMake verifies that the library exists before
 # completing its build.

 find_library( # Sets the name of the path variable.
         log-lib

         # Specifies the name of the NDK library that
         # you want CMake to locate.
         log
         android)


 include_directories(
         ${CMAKE_SOURCE_DIR}/src/main/cpp/include/${ANDROID_ABI}
 )
 # 编解码
 add_library(libavcodec
         SHARED
         IMPORTED)
 set_target_properties(libavcodec PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavcodec.so)
 # 和多媒体设备交互的类库
 add_library(libavdevice
         SHARED
         IMPORTED)
 set_target_properties(libavdevice PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavdevice.so)
 # 图像的pixel format处理
 add_library(libavfilter
         SHARED
         IMPORTED)
 set_target_properties(libavfilter PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavfilter.so)
 # 格式
 add_library(libavformat
         SHARED
         IMPORTED)
 set_target_properties(libavformat PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavformat.so)

 # 工具函数
 add_library(libavutil
         SHARED
         IMPORTED)
 set_target_properties(libavutil PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavutil.so)

 # 音频重采样，采样格式转换和混合库
 add_library(libswresample
         SHARED
         IMPORTED)
 set_target_properties(libswresample PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswresample.so)

 # 缩放处理
 add_library(libswscale
         SHARED
         IMPORTED)
 set_target_properties(libswscale PROPERTIES IMPORTED_LOCATION
         ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswscale.so)