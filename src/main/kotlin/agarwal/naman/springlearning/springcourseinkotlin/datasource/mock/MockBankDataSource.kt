package agarwal.naman.springlearning.springcourseinkotlin.datasource.mock;

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.model.Bank

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.datasource.mock
Project Name: springcourseinkotlin
Date: 08-07-2021
 */

class MockBankDataSource: BankDataSource {

    override fun getBanks(): Collection<Bank> {
        TODO("Not yet implemented")
    }
}
