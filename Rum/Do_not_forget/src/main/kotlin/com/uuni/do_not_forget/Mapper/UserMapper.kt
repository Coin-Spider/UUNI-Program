package com.uuni.do_not_forget.Mapper

import com.uuni.do_not_forget.Pojo.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun registered(user: User)
    fun login(user: User):User
}