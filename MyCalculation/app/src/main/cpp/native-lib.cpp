#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_mycalculation_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_mycalculation_MainActivity_add(JNIEnv *env, jobject instance, jint a, jint b) {

    return (a+b);

}extern "C"
JNIEXPORT jint JNICALL
Java_com_example_mycalculation_MainActivity_sub(JNIEnv *env, jobject instance, jint a, jint b) {

    return (a-b);

}extern "C"
JNIEXPORT jint JNICALL
Java_com_example_mycalculation_MainActivity_multiply(JNIEnv *env, jobject instance, jint a,
                                                     jint b) {

    return (a*b);

}extern "C"
JNIEXPORT jint JNICALL
Java_com_example_mycalculation_MainActivity_divide(JNIEnv *env, jobject instance, jint a, jint b) {

    return (a/b);

}