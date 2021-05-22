package com.gl.appoptimize.crash

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gl.appoptimize.R
import com.tencent.bugly.crashreport.CrashReport

class CrashActivity : AppCompatActivity() {
    private val TAG = "CrashActivity"
    private lateinit var tvBlock: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block)
        tvBlock = findViewById(R.id.tv_block)
        tvBlock.setOnClickListener({ CrashReport.testJavaCrash() })
    }

}