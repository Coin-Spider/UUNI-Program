package com.uuni.do_not_forget.Mapper

import com.uuni.do_not_forget.Pojo.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    fun registered(user: User)
    fun login(user: User):User
    //检查用户是否存在
    fun checkCount(user: User):Int
    //根据username查询用户
    @Select("select * from user where userName=#{userName};")
    fun byUserName(userName:String):User
}