package agarwal.naman.springlearning.springcourseinkotlin.service;

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.datasource.mock.MockBankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import org.springframework.stereotype.Service

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.service
Project Name: springcourseinkotlin
Date: 20-07-2021
 */

@Service
class BankService(private val bankDataSource: BankDataSource) {
        fun getBanks() : Collection<Bank> = bankDataSource.retrieveBanks()
        fun getBank(accountNumber: String) {
                return bankDataSource.getbank(accountNumber)
        }
}

// @Service: Like @Repository annotation, it tells spring boot to make this bean/class or an object of
// it available at runtime. So it is available in the application context and it can be injected by a
// dependency injection into other objects and classes.