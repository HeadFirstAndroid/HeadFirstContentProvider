package me.yifeiyuan.headfirstcontentprovider

import android.app.Application

/**
 * Created by 程序亦非猿 on 2020/10/15.
 */
class App : Application() {

    override fun onCreate() {
        println("before Application onCreate")
        super.onCreate()
        println("after Application onCreate")
    }
}