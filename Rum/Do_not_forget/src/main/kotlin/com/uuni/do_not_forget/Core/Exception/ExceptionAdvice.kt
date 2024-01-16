package com.uuni.do_not_forget.Core.Exception

import com.uuni.do_not_forget.Core.Request
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@ControllerAdvice
@ResponseBody
class ExceptionAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ForgetException::class)
    fun handleException(e:ForgetException): Request? {
        println(e.printStackTrace())
        return Request(e.code,e.message);
    }
}