package agarwal.naman.springlearning.springcourseinkotlin.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc
    
    @Test
    fun `should return all banks`(){
         // when/then
        mockMvc.get("/api/banks/get")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") {value("123")}
            }
    }
    
    @Test
    fun `should return the bank with given account number`(){
         // given
         val accountNumber = "1234"
         
         // when/then
         mockMvc.get("/api/banks/$accountNumber")
             .andDo { print() }
             .andExpect { status { isOk() } }
         
    }
}

/**
 * @SpringBootTest: This will trigger spring boot to initialize the entire application context and even
 * start up the actual application for these tests. It will be a integration test that integrates the
 * whole application(initializes all beans, classes and objects).
 *
 * MockMvc: It should only be used in tests as it will allow us to make requests to our end rest api
 * without actually issuing any http request.
 *
 * @Autowired: It tell spring boot to give the bean of this object automatically when we run test. In short
 * it is responsible for initializing a object of this type and assigning it to this variable.
 *
 * @AutoConfigureMockMvc: @SpringBootTest will only initialize our own application context(i.e classes
 * we had created. It will give error because when initializing application context, it will observe
 * that this MockMvc variable is uninitialized and it will throw error ).
 * To create object of MockMvc, we use this annotation. Without this annotation,
 * @Autowired notation will also not work.
 */