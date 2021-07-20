package agarwal.naman.springlearning.springcourseinkotlin.service

import agarwal.naman.springlearning.springcourseinkotlin.datasource.BankDataSource
import agarwal.naman.springlearning.springcourseinkotlin.datasource.mock.MockBankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest{
    private val bankDataSource : BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(bankDataSource = bankDataSource)
    
    @Test
    fun `should call its datasource to retrieve banks`(){
         // given
//        every { bankDataSource.retrieveBanks() } returns emptyList()
         
         // when
         val banks = bankService.getBanks()
         
         // then
        verify(exactly = 1) { bankDataSource.retrieveBanks() }
    }

}


/**
 * every { bankDataSource.retrieveBanks() } returns emptyList() : This is important because bankDataSource
 * is of mockk type. When val banks = bankService.getBanks() was executed then it goes to the getBanks()
 * method and there retrieveBanks() method was called on bankDataSource instance. But since bankDataSource
 * that was passed was of mockk type, it doesn't know what to do when retrieveBanks() method was called.
 *
 * So, its necessary to specify that what should be done when retrieveBank() method was called.
 *
 * An alternate way of doing this is assigning the relaxed value in mockk constructor.
 */










