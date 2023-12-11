package com.uuni.do_not_forget.Service.Impl

import com.uuni.do_not_forget.Mapper.ForgetTableMapper
import com.uuni.do_not_forget.Pojo.ForgetTable
import com.uuni.do_not_forget.Service.ForgetTableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ForgetTableServiceImpl:ForgetTableService {
    @Autowired lateinit var forgetTableMapper: ForgetTableMapper

    /**
     * 添加备忘录
     */
    override fun addForget(forgetTable: ForgetTable) {
        forgetTableMapper.addForgetTable(forgetTable)
    }
}