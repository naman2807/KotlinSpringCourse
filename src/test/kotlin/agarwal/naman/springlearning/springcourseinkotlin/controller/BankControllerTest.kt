package agarwal.naman.springlearning.springcourseinkotlin.controller

import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
        val mockMvc: MockMvc,
        val objectMapper: ObjectMapper
){
    @Nested
    @DisplayName("GET api/banks/get")
    @TestInstance(PER_CLASS)
    inner class GetBanks{
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
    }

    @Nested
    @DisplayName("GET api/banks/get/accountNumber")
    @TestInstance(PER_CLASS)
    inner class GetBank{
        @Test
        fun `should return the bank with given account number`(){
            // given
            val accountNumber = 123

            // when/then
            mockMvc.get("/api/banks/get/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") {value("1.2")}
                }

        }
        
        @Test
        fun `should return NOT FOUND if account number does not exist`(){
             // given
             val accountNumber = "does_not_exist"
             
             // when/then
            mockMvc.get("/api/banks/get/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
             
        }
    }

    @Nested
    @DisplayName("POST api/banks/post")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostBank{
        @Test
        fun `should add the bank`(){
             // given
             val newBank = Bank("1234",2.3,5)
             
             // when
            val response = mockMvc.post("/api/banks/post"){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            // then
            response
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber") {value("1234")}
                }

            mockMvc.get("/api/banks/get/${newBank.accountNumber}")
                .andExpect { content { json(objectMapper.writeValueAsString(newBank)) } }
        }
        
        @Test
        fun `should return BAD REQUEST if bank with given account number already exist`(){
             // given
             val invalidBank = Bank("123", 2.3,2)
             
             // when
             val response  = mockMvc.post("/api/banks/post"){
                 contentType = MediaType.APPLICATION_JSON
                 content = objectMapper.writeValueAsString(invalidBank)
             }
             
             // then
             response.andDo { print() }
                 .andExpect {
                     status { isBadRequest() } 
                 }
        }
    }

    @Nested
    @DisplayName("PATCH api/banks/patch")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PatchExistingBank{
        @Test
        fun `should update an existing bank`(){
             // given
             val updatedBank = Bank("123",2.3,2)
             
             // when
            val responsePatch = mockMvc.patch("/api/banks/patch"){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedBank)
            }

            // then
            responsePatch
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                }

            mockMvc.get("/api/banks/get/${updatedBank.accountNumber}")
                .andExpect { content { json(objectMapper.writeValueAsString(updatedBank)) } }
        }
        
        @Test
        fun `should return NOT FOUND if the bank does not exist `(){
             // given
             val invalidBank = Bank("does_not_exist",2.3,2)
             
             // when
            val response = mockMvc.patch("/api/banks/patch"){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidBank)
            }
             
             // then
            response.andDo { print() }
                .andExpect { status { isNotFound() } }
             
        }
    }

    @Nested
    @DisplayName("DELETE api/banks/delete/accountNumber")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class DeleteBank{
        @Test
        fun `should delete the bank with given account number`(){
             // given
             val accountNumber = 123
             
             // when/then
            mockMvc.delete("/api/banks/delete/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNoContent() } }

            mockMvc.get("/api/banks/get/$accountNumber")
                .andExpect { status { isNotFound() } }
        }
        
        @Test
        fun `should return NOT FOUND if bank with given account number does not exist`(){
             // given
             val accountNumber = "does_not_exist"
             
             // when/then
            mockMvc.delete("/api/banks/delete/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound()} }
             
        }
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
 *
 * ObjectMapper: Used for serialization and deserialization of objects. Here serialization is being done.
 */