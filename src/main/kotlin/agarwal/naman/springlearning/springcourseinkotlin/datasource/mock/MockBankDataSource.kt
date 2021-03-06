package agarwal.naman.springlearning.springcourseinkotlin.datasource.mock;

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.datasource.mock
Project Name: springcourseinkotlin
Date: 08-07-2021
 */

@Repository
class MockBankDataSource: BankDataSource {
    val banks = mutableListOf(Bank("123", 1.2, 1),
                        Bank("234",2.3,2),
                        Bank("456",1.0,0))

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() {it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("No bank account found with account number: $accountNumber")

    override fun addBank(bank: Bank): Bank {
        if(banks.any { it.accountNumber == bank.accountNumber }){
            throw IllegalArgumentException("Bank with given account number: ${bank.accountNumber} already exist.")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?:throw NoSuchElementException("No bank with account number: ${bank.accountNumber} exists.")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun removeBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?:throw NoSuchElementException("No bank with account number: $accountNumber exists.")

        banks.remove(currentBank)
    }


}

//@Repository marks MockBankDataSource class as Spring Boot bean. So this adds it to application context
//and it tells spring to initialize this bean/object at runtime and it also tells spring that it is not
//just any bean/object, it's in fact a repository which has few implications later on, for instance when
//testing things.

//In other words, marking class as @Repository means that class is responsible for retrieving data, deleting
//data, updating data etc.