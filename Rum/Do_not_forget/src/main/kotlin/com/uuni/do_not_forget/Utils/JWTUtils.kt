package com.uuni.do_not_forget.Utils

import com.auth0.jwt.*
import com.auth0.jwt.algorithms.Algorithm
import com.uuni.do_not_forget.Core.Exception.ApiException
import com.uuni.do_not_forget.Core.Exception.ForgetException
import java.util.*

class JWTUtils {
    private val ddl=1000*60*60*24L//1天
    private val secret="$2a$10\$XMDs/IRP/rjB6RmC4Pz7tu"
    //创将token
    fun createToken(userName:String):String{
        val now=System.currentTimeMillis()//获取系统时间
        return JWT.create()
                .withClaim("UserName",userName)//签名负荷
                .withIssuedAt(Date(now))//签名时间
                .withIssuer(userName)//签发主体
                .withJWTId(UUID.randomUUID().toString())//tokenId
                .withExpiresAt(Date(now+ddl))
                .sign(Algorithm.HMAC256(secret))//签名方法
    }
    //验证token
    fun verify(token:String){
        try {
            val verifier=JWT.require(Algorithm.HMAC256(secret)).build().verify(token)

            if (Date(System.currentTimeMillis())>=verifier.expiresAt){
                throw ForgetException(ApiException.TokenTimed.code,ApiException.TokenTimed.message)
            }
        }catch (e:Exception){
            throw ForgetException(ApiException.TokenNotMatched.code,ApiException.TokenNotMatched.message)
        }
    }
}