package com.uuni.do_not_forget.Filter.JWT

import com.auth0.jwt.JWT
import com.uuni.do_not_forget.Core.Exception.ApiException
import com.uuni.do_not_forget.Core.Exception.ForgetException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import java.util.*


@Component
class JwtAuthenticationTokenFilter: GenericFilterBean() {
    override fun doFilter(request:ServletRequest,
     response:ServletResponse,
    chain:FilterChain ){

        //强转
        val httpRequest=request as HttpServletRequest
        //查看是否是肯定没有token的请求
        println(request.requestURL)
        request.requestURL.let {
            if (it.startsWith("http://127.0.0.1:8080/User/Login")){
                chain.doFilter(request,response)
                return
            }else if (it.startsWith("http://127.0.0.1:8080/User/Registered")){
                chain.doFilter(request,response)
                return
            }
        }

        // 从请求头中获取token
        var token =httpRequest.getHeader("authToken")
        //看token是否存在
        token?:throw ForgetException(ApiException.NoToken.code,ApiException.NoToken.message)
        // 截取token
        if (token.startsWith(("Bearer "))) {
            // token前面的"Bearer "需要截取
            token = token.substring(7)
        }
        println("authToken:${token}")
        //验证token,获取token中的username
        val decoded = JWT.decode(token)
        decoded.claims["UserName"]?: throw ForgetException(ApiException.TokenNotMatched.code,ApiException.TokenNotMatched.message)//检查是否为标准签名格式
        // 校验该token是否过期
        if (decoded.expiresAt.before(Date())){
            throw ForgetException(ApiException.TokenTimed.code,ApiException.TokenTimed.message)
        }

        chain.doFilter(request, response)
    }






}