package com.uuni.do_not_forget.Core

data class Request(
    var isSuccess: Int,//1:成功 2:失败
    var body:Any?=null
)
