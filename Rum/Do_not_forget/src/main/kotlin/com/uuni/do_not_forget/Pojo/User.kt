package com.uuni.do_not_forget.Pojo

data class User(
    var userId :Int ?=null,
    var userName :String ?=null,
    var userPass :String ?=null,
    var count:Int?=null,
    var salt:String?=null,
    var userToken:String?=null,
)
