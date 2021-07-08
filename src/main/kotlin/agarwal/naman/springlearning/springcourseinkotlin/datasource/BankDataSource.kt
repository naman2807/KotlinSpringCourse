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

    fun getBanks() : Collection<Bank>
}
