package com.gl.appoptimize

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.dianping.logan.Logan
import com.dianping.logan.LoganConfig
import com.didichuxing.doraemonkit.DoKit
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.matrix.Matrix
import com.tencent.matrix.iocanary.IOCanaryPlugin
import com.tencent.matrix.iocanary.config.IOConfig
import com.tencent.matrix.plugin.DefaultPluginListener
import com.tencent.matrix.report.Issue
import com.tencent.matrix.util.MatrixLog
import com.tencent.mrs.plugin.IDynamicConfig
import java.io.File
import java.util.concurrent.TimeUnit
import com.gl.appoptimize.crash.CrashHandler


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        // 初始化bugly
        CrashReport.initCrashReport(applicationContext, "5e41caa713", false)
        // 初始化Matrix
//        initMatrx()
        // 初始化DoraemonKit
//        DoKit.Builder(this)
//            .productId("d344d03a7e")
//            .build()
        // 初始化Logan
        val config = LoganConfig.Builder()
            .setCachePath(applicationContext.filesDir.absolutePath)
            .setPath(
                applicationContext.getExternalFilesDir(null)!!.absolutePath
                        + File.separator + "logan_v1"
            )
            .setEncryptKey16("0123456789012345".toByteArray())
            .setEncryptIV16("0123456789012345".toByteArray())
            .setDay(3)
            .build()
        Logan.init(config)
        val crashHandler = CrashHandler.instance
        crashHandler.init(applicationContext)
    }

    fun initMatrx() {
        val builder: Matrix.Builder = Matrix.Builder(this) // build matrix
        builder.patchListener(TestPluginListener(this)) // add general pluginListener
        val dynamicConfig = DynamicConfigImplDemo()

        // init plugin
        val ioCanaryPlugin = IOCanaryPlugin(
            IOConfig.Builder()
                .dynamicConfig(dynamicConfig)
                .build()
        )
        //add to matrix
        builder.plugin(ioCanaryPlugin)
        //init matrix
        Matrix.init(builder.build())
        // start plugin
//        ioCanaryPlugin.start()
    }

    class DynamicConfigImplDemo : IDynamicConfig {
        val isFPSEnable: Boolean
            get() = true
        val isTraceEnable: Boolean
            get() = true
        val isMatrixEnable: Boolean
            get() = true
        val isDumpHprof: Boolean
            get() = false

        override fun get(key: String, defStr: String): String {
            //hook to change default values
            return defStr
        }

        override fun get(key: String, defInt: Int): Int {
            //hook to change default values
            return defInt
        }

        override fun get(key: String, defLong: Long): Long {
            //hook to change default values
            return defLong
        }

        override fun get(key: String, defBool: Boolean): Boolean {
            //hook to change default values
            return defBool
        }

        override fun get(key: String, defFloat: Float): Float {
            //hook to change default values
            return defFloat
        }
    }

    class TestPluginListener(context: Context?) : DefaultPluginListener(context) {
        override fun onReportIssue(issue: Issue) {
            super.onReportIssue(issue)
            MatrixLog.e(TAG, issue.toString())
            //add your code to process data
        }

        companion object {
            const val TAG = "Matrix.TestPluginListener"
        }
    }


}