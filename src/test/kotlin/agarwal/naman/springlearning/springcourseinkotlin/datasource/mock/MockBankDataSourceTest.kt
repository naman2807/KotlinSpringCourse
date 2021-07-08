package agarwal.naman.springlearning.springcourseinkotlin.datasource.mock

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{
    private val mockBankDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`(){
         // given

         
         // when
        val banks = mockBankDataSource.getBanks()
         
         // then
        assertThat(banks).isNotEmpty
    }

    @Test
    fun `should provide some mock data`(){
         // given


         // when
        val banks = mockBankDataSource.getBanks()

         // then
        assertThat(banks).allSatisfy{ it.accountNumber.isNotBlank()}
    }
}