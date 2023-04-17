package com.learning.model

val ordersStroage = mutableListOf<Orders>(

    Orders(
        number = "2023-04-17-1",
        orderItems = listOf(
            OrderItem(
                name = "Cheese",
                count = 3,
                price = 20.0
            ),
            OrderItem(
                name = "Milk",
                count = 2,
                price = 40.0
            ),
            OrderItem(
                name = "Bread",
                count = 4,
                price = 10.0
            ),
        )
    ),
    Orders(
        number = "2023-04-16-1",
        orderItems = listOf(
            OrderItem(
                name = "T-shirt",
                count = 1,
                price = 450.0
            ),
            OrderItem(
                name = "Jeans",
                count = 2,
                price = 400.0
            ),
        )
    )

)

@kotlinx.serialization.Serializable
data class Orders(
    val number: String,
    val orderItems: List<OrderItem>
)

@kotlinx.serialization.Serializable
data class OrderItem(
    val name: String,
    val count: Int,
    val price: Double
)