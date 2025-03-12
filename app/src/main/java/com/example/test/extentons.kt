package com.example.test

import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val part by lazy { 20 }
    println(part)
}



