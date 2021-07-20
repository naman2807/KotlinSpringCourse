package agarwal.naman.springlearning.springcourseinkotlin.controller

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc
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
 * we had created). To create object of MockMvc, we use this annotation. Without this annotation,
 * @Autowired notation will also not work.
 */