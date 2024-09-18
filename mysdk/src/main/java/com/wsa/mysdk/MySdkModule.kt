package com.wsa.mysdk

import org.koin.dsl.module

val mySdkModule = module {
    single<SecretGeneratorInterface> { SecretGenerator() }
}

