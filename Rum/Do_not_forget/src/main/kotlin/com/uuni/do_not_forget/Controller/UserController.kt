package com.uuni.do_not_forget.Controller

import com.uuni.do_not_forget.Core.Request
import com.uuni.do_not_forget.Pojo.ForgetTable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/User")
class UserController {

    @GetMapping("/Hi")
    fun sayHello():Request{
        return Request(1,"hello")
    }
    @PostMapping("/Add")
    fun addForget(@RequestBody forgetTable: ForgetTable){

    }

}