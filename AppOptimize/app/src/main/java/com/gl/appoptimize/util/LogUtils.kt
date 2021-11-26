package com.gl.appoptimize.util

import android.util.Log

object LogUtils {
    const val LOG_LEVEL_NONE = 0 //不输出任和log
    const val LOG_LEVEL_DEBUG = 1 //调试 蓝色
    const val LOG_LEVEL_INFO = 2 //提现 绿色
    const val LOG_LEVEL_WARN = 3 //警告 橙色
    const val LOG_LEVEL_ERROR = 4 //错误 红色
    const val LOG_LEVEL_ALL = 5 //输出所有等级
    /**
     * 获取Log等级
     *
     * @return
     */
    /**
     * 给输出的Log等级赋值
     *
     * @param level
     */
    /**
     * 允许输出的log日志等级
     * 当出正式版时,把mLogLevel的值改为 LOG_LEVEL_NONE,
     * 就不会输出任何的Log日志了.
     */
    var logLevel = LOG_LEVEL_ALL

    /**
     * 以级别为 d 的形式输出LOG,输出debug调试信息
     */
    fun d(tag: String?, msg: String?) {
        if (logLevel >= LOG_LEVEL_DEBUG) {
            Log.d(tag, msg!!)
        }
    }

    /**
     * 以级别为 i 的形式输出LOG,一般提示性的消息information
     */
    fun i(tag: String?, msg: String?) {
        if (logLevel >= LOG_LEVEL_INFO) {
            Log.i(tag, msg!!)
        }
    }

    /**
     * 以级别为 w 的形式输出LOG,显示warning警告，一般是需要我们注意优化Android代码
     */
    fun w(tag: String?, msg: String?) {
        if (logLevel >= LOG_LEVEL_WARN) {
            Log.w(tag, msg!!)
        }
    }

    /**
     * 以级别为 e 的形式输出LOG ，红色的错误信息，查看错误源的关键
     */
    @JvmStatic
    fun e(tag: String?, msg: String?) {
        if (logLevel >= LOG_LEVEL_ERROR) {
            Log.e(tag, msg!!)
        }
    }

    /**
     * 以级别为 v 的形式输出LOG ，verbose啰嗦的意思
     */
    fun v(tag: String?, msg: String?) {
        if (logLevel >= LOG_LEVEL_ALL) {
            Log.v(tag, msg!!)
        }
    }
}