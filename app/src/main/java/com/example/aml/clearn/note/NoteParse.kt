package com.example.aml.clearn.note

import android.app.Activity
import android.util.Log
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Created by 18624915319 on 2017/12/9.
 */
class NoteParse {

    companion object {
        fun init(aActivity: Activity) {
            val activityClass: Class<Activity> = aActivity.javaClass
            val array: Array<Field> = activityClass.declaredFields
            for (i in 0 until array.size){
                val annotations: NoteInterface = array[i].getAnnotation(NoteInterface::class.java) ?: continue
                val method: Method = activityClass.getMethod("findViewById", Int::class.java)
                val obj = method.invoke(aActivity, annotations.value)
                array[i].isAccessible = true
                array[i].set(aActivity, obj)
            }

        }
    }


}