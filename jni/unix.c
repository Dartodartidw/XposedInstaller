/*
 * vim: set sw=4 ts=4: Author: Liu DongMiao <liudongmiao@gmail.com>
 */

#include <stdio.h>
#include <unistd.h>
#include <jni.h>

#define CLASSNAME "me/piebridge/util/Unix"
#define ARRAY_SIZE(x) (sizeof(x) / sizeof(x[0]))

static jint unix_getppid(JNIEnv * env, jobject clazz)
{
	return (int)getppid();
}

static JNINativeMethod methods[] = {
	/* name, signature, funcPtr */
	{"getppid", "()I", (void *)unix_getppid},
};

jint JNI_OnLoad(JavaVM * vm, void *reserved)
{
	JNIEnv         *env;
	jclass		clazz;

	if ((*vm)->GetEnv(vm, (void **)&env, JNI_VERSION_1_6) != JNI_OK) {
		return -1;
	}
	clazz = (*env)->FindClass(env, CLASSNAME);
	if (clazz == NULL) {
		return -1;
	}
	if ((*env)->RegisterNatives(env, clazz, methods, ARRAY_SIZE(methods)) < 0) {
		return -1;
	}
	return JNI_VERSION_1_6;
}
