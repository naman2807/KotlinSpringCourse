package agarwal.naman.springlearning.springcourseinkotlin.controller;

import agarwal.naman.springlearning.springcourseinkotlin.model.Bank
import agarwal.naman.springlearning.springcourseinkotlin.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException

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

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/get")
    fun getBanks(): Collection<Bank>{
        return service.getBanks()
    }

    @GetMapping("/get/{accountNumber}")
    fun getBank(@PathVariable accountNumber : String): Bank = service.getBank(accountNumber)

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank) : Bank = service.addBank(bank)

    @PatchMapping("/patch")
    fun updateBank(@RequestBody bank: Bank): Bank = service.updateBank(bank)

    fun deleteBank(@PathVariable accountNumber: String): Unit {}
}

/**
 * @RequestBody: Deserializes the object from Json to actual object. Here bank is converted from Json
 * form to actual kotlin object.
 *
 * @PathVariable: Takes the value from URL. Variable name and path ame should be same
 * (here accountNumber).
 *
 * @RestController: Tells spring boot to consider it as a bean and it will be part of application context.
 */