package com.example.aml.clearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import rx.*
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers

class RxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)




    }

    private fun rxText(): Unit {
        var observable: Observable<String> = Observable.create({

        })
        observable.subscribe(object : Subscriber<String>(){
            override fun onCompleted() {

            }

            override fun onNext(t: String?) {

            }

            override fun onError(e: Throwable?) {

            }

        })


    }
}
