package com.uuni.do_not_forget.Core

import com.uuni.do_not_forget.Core.Exception.ForgetException

data class Request(
    var isSuccess: String,//1:成功 0:失败(或其他的报错信息)
    var body:Any?=null
)
