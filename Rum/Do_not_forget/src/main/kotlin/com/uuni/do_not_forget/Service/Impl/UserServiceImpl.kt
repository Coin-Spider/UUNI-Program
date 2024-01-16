package com.uuni.do_not_forget.Service.Impl

import com.uuni.do_not_forget.Core.Exception.ApiException
import com.uuni.do_not_forget.Core.Exception.ForgetException
import com.uuni.do_not_forget.Mapper.UserMapper
import com.uuni.do_not_forget.Pojo.User
import com.uuni.do_not_forget.Service.UserService
import com.uuni.do_not_forget.Utils.JWTUtils
import com.uuni.do_not_forget.Utils.SecretUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl :UserService {
    @Autowired lateinit var userMapper: UserMapper
    override fun registered(user: User):User {
        //检查完用户信息是否齐全后开始正式注册
        //检查用户名是否已经存在
        if (userMapper.checkCount(user)>0){
            //用户名已经存在了
            throw ForgetException(ApiException.NameUsed.code,ApiException.NameUsed.message)
        }
        //不存在,开始生成salt和密码加密
        user.salt=SecretUtils().saltC()
        user.userPass= user.userPass?.let { SecretUtils().enC(it, user.salt!!) }
        //密码加密完成,可以正常添加
        userMapper.registered(user)
        if (userMapper.checkCount(user)==0){
            throw ForgetException(ApiException.RegisFiled.code,ApiException.RegisFiled.message)
        }
        //生成token
        user.userToken=user.userName?.let { JWTUtils().createToken(it) }
        return user
    }

    override fun login(user: User): User {
        //查询是否存在
        if (userMapper.checkCount(user)==0){
            throw ForgetException(ApiException.UserNotFound.code,ApiException.UserNotFound.message)
        }
        val user2= user.userName?.let { userMapper.byUserName(it) }
        if (user2 != null) {
                user.salt?.let { user2.userPass?.let { it1 -> if (!SecretUtils().verify(it1, it)){
                    throw ForgetException(ApiException.PassError.code,ApiException.PassError.message)
                        }
                    }
                }
            user2.userToken= user2.userName?.let { JWTUtils().createToken(it) }
            user2.userPass=null
            user2.salt=null
        }
        return user2!!
    }
}