package com.wsa.mysdk

interface MySdkClassInterface {
    fun getCustomString(): String
}
class MySdkClass: MySdkClassInterface {

    override fun getCustomString(): String {
        return "Hello World"
    }

}
