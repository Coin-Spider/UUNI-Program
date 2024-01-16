package com.uuni.do_not_forget.Utils

import cn.hutool.crypto.digest.BCrypt

class SecretUtils {
    fun enC(userPass:String,salt:String):String{

        return BCrypt.hashpw(userPass,salt)
    }
    fun saltC():String{
        return BCrypt.gensalt()
    }
    fun verify(userPass:String,enc:String):Boolean{
        return BCrypt.checkpw(userPass,enc)
    }
}