package com.example.aml.clearn

import org.junit.Test

/**
 * Created by 18624915319 on 2017/12/16.
 */

class Text {

    fun text(action: () -> Unit): Unit {
        action()
    }

    @Test
    fun main() {
        text {
            print("你好")
        }
        Thread.sleep(10000)

    }
}