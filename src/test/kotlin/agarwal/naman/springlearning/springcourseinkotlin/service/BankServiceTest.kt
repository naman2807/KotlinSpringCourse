package agarwal.naman.springlearning.springcourseinkotlin.service

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.datasource.mock.MockBankDataSource
import org.junit.jupiter.api.Assertions.*

internal class BankServiceTest{
    private val bankDataSource : BankDataSource = mockk()

    private val bankService = BankService(bankDataSource = bankDataSource)

}