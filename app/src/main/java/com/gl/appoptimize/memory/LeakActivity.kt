package com.gl.appoptimize.memory

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.gl.appoptimize.R

class LeakActivity : AppCompatActivity() {
    private val TAG = "LeakActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak)

        // 跳转到新的LeakActivity里执行这段代码，然后退出这个LeakActivity。执行gc。
        Handler().postDelayed({ }, 15000)
    }
}