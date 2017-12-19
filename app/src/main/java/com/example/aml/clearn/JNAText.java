package com.example.aml.clearn;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by 18624915319 on 2017/12/17.
 */

public interface JNAText extends Library {
    public static final String JNA_LIBRARY_NAME = "text";
    public static final JNAText INSTANCE = (JNAText) Native.loadLibrary(JNAText.JNA_LIBRARY_NAME, JNAText.class);

    void text();

}
