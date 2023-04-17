package com.learning.model

val customerStorage = mutableListOf<Customer>(
    Customer(1, "Abc", "xyz", "zt@ff.com"))

@kotlinx.serialization.Serializable
data class Customer(
    val id : Int,
    val firstName : String,
    val lastName : String,
    val email : String
)
