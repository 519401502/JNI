package com.example.aml.clearn.note

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by 18624915319 on 2017/12/8.
 */
@Target(AnnotationTarget.FIELD)
@Retention(RetentionPolicy.RUNTIME)
annotation class TT(val value: Int)
