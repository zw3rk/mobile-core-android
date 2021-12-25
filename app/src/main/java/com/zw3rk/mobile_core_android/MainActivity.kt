package com.zw3rk.mobile_core_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

external fun initHS()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    companion object {
        init {
            System.loadLibrary("mobile_core_test")
            initHS()
        }
    }
}