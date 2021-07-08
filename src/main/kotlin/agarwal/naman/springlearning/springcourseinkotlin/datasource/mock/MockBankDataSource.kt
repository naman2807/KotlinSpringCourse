package agarwal.naman.springlearning.springcourseinkotlin.datasource.mock;

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import org.springframework.stereotype.Repository

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.datasource.mock
Project Name: springcourseinkotlin
Date: 08-07-2021
 */

@Repository
class MockBankDataSource: BankDataSource {

    override fun getBanks(): Collection<Bank> {
        return emptyList()
    }
}

//@Repository marks MockBankDataSource class as Spring Boot bean. So this adds it to application context
//and it tells spring to initialize this bean/object at runtime and it also tells spring that it is not
//just any bean/object, it's in fact a repository which has few implications later on, for instance when
//testing things.

//In other words, marking class as @Repository means that class is responsible for retrieving data, deleting
//data, updating data etc.