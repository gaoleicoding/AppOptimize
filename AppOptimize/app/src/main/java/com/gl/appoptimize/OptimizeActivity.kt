package com.gl.appoptimize

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gl.appoptimize.block.BlockActivity
import com.gl.appoptimize.memory.LeakActivity

class OptimizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_optimize)
    }

    @Synchronized
    fun toLeakActivity(view: View?) {
        startActivity(Intent(this, LeakActivity::class.java))
    }

    fun toBlockActivity(view: View?) {
        synchronized(this) { startActivity(Intent(this, BlockActivity::class.java)) }
    }

    fun toCrashActivity(view: View?) {
        synchronized(this) { startActivity(Intent(this, BlockActivity::class.java)) }
    }
}