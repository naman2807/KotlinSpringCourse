package agarwal.naman.springlearning.springcourseinkotlin.datasource.mock

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{
    private val mockBankDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`(){
         // given

         
         // when
        val banks = mockBankDataSource.getBanks()
         
         // then

    }
}