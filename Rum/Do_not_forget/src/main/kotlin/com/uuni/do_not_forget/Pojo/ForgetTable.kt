package com.uuni.do_not_forget.Pojo

import java.sql.Timestamp

data class ForgetTable(
    var tableId: Int,
    var tableContent:String?=null,
    var tableFinished:Int,
    var tableCreatetime: Timestamp?=null,
    var tableDeadline: Timestamp,
    var tableFiled:Int,
    var userId :Int,
)
