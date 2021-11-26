package com.gl.appoptimize.crash

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gl.appoptimize.R

class CrashActivity : AppCompatActivity() {
    private val TAG = "CrashActivity"
    private lateinit var tvCrash: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash)
        tvCrash = findViewById(R.id.tv_crash)
        tvCrash.setOnClickListener({
            tvCrash.text = "Allen"
//            CrashReport.testJavaCrash()
            throw  RuntimeException("抛出一个异常")
        })
    }

}