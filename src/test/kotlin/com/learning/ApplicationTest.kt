package com.learning

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import com.learning.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}

class OrderRouteTests {

    @Test
    fun testGetOrder() = testApplication {
        val response = client.get("/orders/2023-04-17-1")
//        assertEquals(
//            """{"number":"2023-04-17-1","orderItems":[{"name":"Cheese","count":3,"price":20.0},{"name":"Milk","count":2,"price":40.0},{"name":"Bread","count":4,"price":10.0}]}""",
//            response.bodyAsText()
//        )

        assertEquals(HttpStatusCode.OK, response.status)
    }

}
