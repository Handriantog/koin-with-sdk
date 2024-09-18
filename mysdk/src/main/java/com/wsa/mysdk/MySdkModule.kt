package com.wsa.mysdk

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val mySdkModule = module {
    single<SecretGeneratorInterface> { SecretGenerator() }
}

object MySdk {
    /*private val koinApplication: KoinApplication by lazy {
        startKoin {
            modules(mySdkModule)
        }
    }

    fun getSecretGenerator(): SecretGeneratorInterface {
        return koinApplication.koin.get()
    }*/

    private val isolatedKoinApp = koinApplication {
        modules(mySdkModule)
    }

    val koin = isolatedKoinApp.koin
}