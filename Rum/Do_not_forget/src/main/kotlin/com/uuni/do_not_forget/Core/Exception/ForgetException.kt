package com.uuni.do_not_forget.Core.Exception

class ForgetException (
    val code:String,
    override val message: String?
): Exception(code)
fun ForgetException(apiException:ApiException):ForgetException{
    return ForgetException(apiException.code,apiException.message)
}