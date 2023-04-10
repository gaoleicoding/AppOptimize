package com.gl.appoptimize.block

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gl.appoptimize.R

class BlockActivity : AppCompatActivity() {
    private val TAG = "BlockActivity"
    private lateinit var tvBlock: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block)
        tvBlock = findViewById(R.id.tv_block)
        tvBlock.setOnClickListener({ cpuCalculate() })
    }

    private fun cpuCalculate() {
        var count = 0
        for (i in 0..999) {
            for (j in 0..99) {
                count += i + j
                Log.d(TAG, "count=$count")
            }
        }
        tvBlock.text = count.toString() + ""
    }
}