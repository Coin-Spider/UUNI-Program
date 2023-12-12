package com.uuni.do_not_forget.Service.Impl

import com.uuni.do_not_forget.Mapper.UserMapper
import com.uuni.do_not_forget.Pojo.User
import com.uuni.do_not_forget.Service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl :UserService {
    @Autowired lateinit var userMapper: UserMapper
    override fun registered(user: User):Boolean {
        return try {
            userMapper.registered(user)
            true;
        }catch (e: DataAccessException){
            false
        }
    }

    override fun login(user: User): User {
        return userMapper.login(user)
    }
}