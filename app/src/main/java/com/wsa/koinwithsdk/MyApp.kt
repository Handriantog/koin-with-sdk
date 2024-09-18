package com.wsa.koinwithsdk

import android.app.Application
import com.wsa.mysdk.mySdkModule
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mySdkModule)
        }
    }

}