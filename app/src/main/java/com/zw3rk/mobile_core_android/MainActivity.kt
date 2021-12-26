package com.zw3rk.mobile_core_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

external fun initHS()
external fun hello() : String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.example)
        tv.text = hello()
    }
    companion object {
        init {
            System.loadLibrary("mobile_core_android")
            initHS()
        }
    }
}