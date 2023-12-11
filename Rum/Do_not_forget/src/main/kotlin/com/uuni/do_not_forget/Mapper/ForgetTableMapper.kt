package com.uuni.do_not_forget.Mapper

import com.uuni.do_not_forget.Pojo.ForgetTable
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ForgetTableMapper {

    fun addForgetTable(forgetTable: ForgetTable)
}