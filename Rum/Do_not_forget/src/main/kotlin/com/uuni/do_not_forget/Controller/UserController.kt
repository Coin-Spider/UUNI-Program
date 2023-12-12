package com.uuni.do_not_forget.Controller

import com.uuni.do_not_forget.Core.Request
import com.uuni.do_not_forget.Pojo.ForgetTable
import com.uuni.do_not_forget.Pojo.User
import com.uuni.do_not_forget.Service.ForgetTableService
import com.uuni.do_not_forget.Service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.HashMap

@RestController
@RequestMapping("/User")
class UserController {
    @Autowired lateinit var forgetTableService:ForgetTableService
    @Autowired lateinit var userService:UserService

    @GetMapping("/Hi")
    fun sayHello():Request{
        return Request(1,"hello")
    }

    /**
     * 注册
     */
    @PostMapping("/Registered")
    fun registered(@RequestBody user: User):Request{
        if(!userService.registered(user)){
            return Request(0,"ERROR")
        }
        return Request(1,"NICE TO MEET YOU ${user.userName}")
    }
    /**
     * 登录
     */
    @GetMapping("/Login")
    fun login(@RequestBody user: User):Request{
        val user2= userService.login(user)
        val map= HashMap<String,Any>()
        map["message"] = "WELCOME ${user2.userName}"
        map["user"] = user2
        return Request(1,map)
    }
    @PostMapping("/Add")
    fun addForget(@RequestBody forgetTable: ForgetTable){
        forgetTableService.addForget(forgetTable);
    }

}