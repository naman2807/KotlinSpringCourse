package agarwal.naman.springlearning.springcourseinkotlin.datasource;

import agarwal.naman.springlearning.springcourseinkotlin.model.Bank

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.datasource
Project Name: springcourseinkotlin
Date: 08-07-2021
 */

interface BankDataSource {

    fun retrieveBanks() : Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun addBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
    fun removeBank(accountNumber: String)
}
