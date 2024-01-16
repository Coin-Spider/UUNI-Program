package com.uuni.do_not_forget

import com.uuni.do_not_forget.Utils.JWTUtils
import com.uuni.do_not_forget.Utils.SecretUtils
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class DoNotForgetApplicationTests {

    @Test
    fun contextLoads() {
    }

}

fun main(args:Array<String>){
    val pass="winhulin"
    val saltC = SecretUtils().saltC()
    println("saltC: $saltC")
    val enC = SecretUtils().enC(pass, saltC)
    println("enC: $enC")
    println(SecretUtils().verify(pass,saltC,enC))
}
