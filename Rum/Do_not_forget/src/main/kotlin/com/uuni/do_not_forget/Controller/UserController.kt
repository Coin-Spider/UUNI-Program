package com.uuni.do_not_forget.Controller

import com.uuni.do_not_forget.Core.Exception.ApiException
import com.uuni.do_not_forget.Core.Exception.ForgetException
import com.uuni.do_not_forget.Core.Request
import com.uuni.do_not_forget.Pojo.ForgetTable
import com.uuni.do_not_forget.Pojo.User
import com.uuni.do_not_forget.Service.ForgetTableService
import com.uuni.do_not_forget.Service.UserService
import com.uuni.do_not_forget.Utils.JWTUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.HashMap

@RestController
@RequestMapping("/User")
/**
 * @folder
 * 用户模块操作
 */
class UserController {
    @Autowired lateinit var forgetTableService:ForgetTableService
    @Autowired lateinit var userService:UserService

    /**
     * 鉴权测试接口
     */
    @RequestMapping("/Test")
    fun test():Request{
        return Request("1","hello")
    }

    /**
     * 注册
     */
    @PostMapping("/Registered")
    fun registered(@RequestBody user: User):Request{
        if (user.userName==null||user.userName.equals("")){
            throw ForgetException(ApiException.InfoLose.code,ApiException.InfoLose.message)
        }
        if(user.userPass==null||user.userPass.equals("")){
            throw ForgetException(ApiException.InfoLose.code,ApiException.InfoLose.message)
        }
        return Request("1",userService.registered(user))
    }
    /**
     * 登录
     */
    @PostMapping("/Login")
    fun login(@RequestBody user: User):Request{
        if ((user.userPass==null||user.userPass.equals(""))||(user.userName==null||user.userName.equals(""))){
            throw ForgetException(ApiException.InfoLose.code,ApiException.InfoLose.message)
        }
        return Request("1",userService.login(user))
    }

    /**
     * 添加备忘录
     */
    @PostMapping("/Add")
    fun addForget(@RequestBody forgetTable: ForgetTable):Request{
        forgetTableService.addForget(forgetTable);
        return Request("1","添加成功")
    }
    /**
     * 查询属于自己的备忘录(进行中)
     */
    @GetMapping("/ForgetTableING/{userId}")
    fun searchForgetTableING(@PathVariable("userId") userId:Int):Request{
        val forgetTable = forgetTableService.searchForgetTable(userId)
        return Request("1",forgetTable)
    }
//    /**
//     * 查询属于自己的备忘录(过期)
//     */
//    @GetMapping("/ForgetTableED/{userId}")
//    fun searchForgetTableED(@PathVariable("userId") userId:Int):Request{
//        val forgetTable = forgetTableService.searchForgetTable(userId)
//        return Request(1,forgetTable)
//    }
}