package agarwal.naman.springlearning.springcourseinkotlin.service

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.datasource.mock.MockBankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest{
    private val bankDataSource : BankDataSource = mockk()

    private val bankService = BankService(bankDataSource = bankDataSource)
    
    @Test
    fun `should call its datasource to retrieve banks`(){
         // given
        every { bankDataSource.retrieveBanks() } returns emptyList()
         
         // when
         val banks = bankService.getBanks()
         
         // then
        verify(exactly = 1) { bankDataSource.retrieveBanks() }
    }

}