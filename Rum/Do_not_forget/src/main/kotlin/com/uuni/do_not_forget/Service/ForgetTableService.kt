package com.uuni.do_not_forget.Service

import com.uuni.do_not_forget.Pojo.ForgetTable
import org.springframework.stereotype.Service

@Service
interface ForgetTableService {
    /**
     * 添加备忘录
     */
    fun addForget(forgetTable: ForgetTable)
}