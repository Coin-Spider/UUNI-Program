package com.uuni.do_not_forget.Service

import com.uuni.do_not_forget.Pojo.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun registered(user: User):User
    fun login(user: User):User
}