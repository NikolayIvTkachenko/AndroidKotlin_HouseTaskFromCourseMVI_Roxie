package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01

import android.app.Application
import android.content.Context
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.di.DependencyInjection
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.di.DependencyInjectionImpl
import com.ww.roxie.Roxie

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

open class App : Application() {

    companion object{
        private var di: DependencyInjection? = null

        fun getAppDi(): DependencyInjection {
            return di!!
        }
    }

//    open val di: DependencyInjection by lazy {
//        DependencyInjectionImpl()
//    }

    override fun onCreate() {
        super.onCreate()
        di = DependencyInjectionImpl()
        Roxie.enableLogging()
    }
}

//var Context.di: DependencyInjection
//    get() = (this.applicationContext as App).di

