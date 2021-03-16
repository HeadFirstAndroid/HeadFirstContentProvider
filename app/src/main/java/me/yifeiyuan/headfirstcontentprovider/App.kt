package me.yifeiyuan.headfirstcontentprovider

import android.app.Application
import me.yifeiyuan.adh.DebugConfig
import me.yifeiyuan.adh.DebugHelper

/**
 * Created by 程序亦非猿 on 2020/10/15.
 */
class App : Application() {

    override fun onCreate() {
        println("before Application onCreate")
        super.onCreate()
        println("after Application onCreate")

        DebugHelper.setup(DebugConfig().apply {
            application = this@App
        })
    }
}