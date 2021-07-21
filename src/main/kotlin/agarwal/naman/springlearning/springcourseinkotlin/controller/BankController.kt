package agarwal.naman.springlearning.springcourseinkotlin.controller;

import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import agarwal.naman.springlearning.springcourseinkotlin.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
Created By: Naman Agarwal
User ID: naman2807
Package Name: agarwal.naman.springlearning.springcourseinkotlin.controller
Project Name: springcourseinkotlin
Date: 20-07-2021
 */

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @GetMapping("/get")
    fun getBanks(): Collection<Bank>{
        return service.getBanks()
    }

    @GetMapping("/get/{accountNumber}")
    fun getBank(@PathVariable accountNumber : String): Bank = service.getBank(accountNumber)
}

/**
 * @RestController: Tells spring boot to consider it as a bean and it will be part of application context.
 */