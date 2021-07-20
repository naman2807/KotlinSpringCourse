package agarwal.naman.springlearning.springcourseinkotlin.controller;

import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import org.springframework.web.bind.annotation.GetMapping
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
class BankController {

    @GetMapping("/get")
    fun getBanks(): Collection<Bank>{

    }
}

/**
 * @RestController: Tells spring boot to consider it as a bean and it will be part of application context.
 */