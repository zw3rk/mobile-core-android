#include <jni.h>

// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("mobile_core_android");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("mobile_core_android")
//      }
//    }

extern "C" void hs_init(int * argc, char **argv[]);
extern "C" char *hello(void);

extern "C"
JNIEXPORT void JNICALL
Java_com_zw3rk_mobile_1core_1android_MainActivityKt_initHS(JNIEnv *env, jclass clazz) {
    hs_init(NULL, NULL);
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_zw3rk_mobile_1core_1android_MainActivityKt_hello(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF(hello());
}