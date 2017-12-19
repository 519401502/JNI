#include <jni.h>
#include <string>
#include <android/log.h>
#include <android/bitmap.h>
#include <string.h>


#define TAG    "xvhuichuang" // 这个是自定义的LOG的标识
#define LOGD(__VA_ARGS__)  __android_log_print(ANDROID_LOG_DEBUG,TAG,"%s",(__VA_ARGS__))

using namespace std;


JNIEXPORT void JNICALL Java_com_example_aml_clearn_KotlinActivity_objectToJNI(JNIEnv *env, jobject /* this */, jobject aClass){
    jclass zhao = env->FindClass("com/example/aml/clearn/Zhao");

    jfieldID  ajfieldId = env->GetFieldID(zhao, "age", "I");
//    jint age = env->GetIntField(aClass, ajfieldId);
//    LOGD("年龄是 = "+age);
}


void text(){
    printf("测试一下JNA");
}


extern "C" JNIEXPORT jstring JNICALL Java_com_example_aml_clearn_KotlinActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
//    这个事自定义的LOG的标识，Java_com
    string hello = "Hello from C++";
    AndroidBitmapInfo *bitmapInfo = new AndroidBitmapInfo();

    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_aml_clearn_KotlinActivity_text(JNIEnv *env, jobject /* this */) {
    string js = "我是JNI，这是我打印的日志";
    jboolean *b = JNI_FALSE;
    const char *aName = env->GetStringUTFChars(env->NewStringUTF(js.c_str()), b);
//    __android_log_print(LOG_DEBUG, TAG, "%s", aName);
    LOGD(aName);
//    const char *arra = env->GetStringUTFChars(aJstring, JNI_FALSE);
//    printf("JNI收到的信息 = %s", arra);
//    env->GetCharArrayElements()
//    return env->NewString(*arra, );
    const char content[100] = "你好啊，我是JNI";
    const char *ip = content;
    return env->NewStringUTF(ip);
}

