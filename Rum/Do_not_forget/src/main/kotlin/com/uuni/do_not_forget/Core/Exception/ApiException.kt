package com.uuni.do_not_forget.Core.Exception

enum class ApiException(val code: String, val message: String) {
    PassError("Error_10001","密码错误"),
    UserNotFound("Error_10002","用户不存在"),
    InfoLose("ERROR_10003","内容缺少或丢失"),
    NameUsed("ERROR_10004","用户名以存在"),
    RegisFiled("ERROR_10005","注册失败"),
    TokenNotMatched("ERROR_10006","签名异常"),
    TokenTimed("ERROR_10007","签名过期,请重新登录"),
    NoAccessed("ERROR_10008","无权限查看"),
    NoToken("ERROR_10009","Token丢失")
}