package com.gl.appoptimize.block

import android.util.Log
import android.view.Choreographer

object ChoreographerHelper {
    private const val TAG = "ChoreographerHelper"
    fun start() {
        Choreographer.getInstance().postFrameCallback(object : Choreographer.FrameCallback {
            var lastFrameTimeNanos: Long = 0
            override fun doFrame(frameTimeNanos: Long) {
                //上次回调时间
                if (lastFrameTimeNanos == 0L) {
                    lastFrameTimeNanos = frameTimeNanos
                    Choreographer.getInstance().postFrameCallback(this)
                    return
                }
                val diff = frameTimeNanos - lastFrameTimeNanos
                if (diff > 16.6f) {
                    //掉帧数
                    val droppedFrameCount = (diff / 16.6).toInt()
                    Log.d(TAG, "doFrame: droppedFrameCount=$droppedFrameCount")
                }
                lastFrameTimeNanos = frameTimeNanos
                Choreographer.getInstance().postFrameCallback(this)
            }
        })
    }
}