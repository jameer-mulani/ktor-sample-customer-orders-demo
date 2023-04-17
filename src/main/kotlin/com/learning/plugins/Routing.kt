package com.learning.plugins

import com.learning.routes.customerRouting
import com.learning.routes.getOrderRoute
import com.learning.routes.getOrderTotal
import com.learning.routes.listOrdersRoute
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        getOrderTotal()
    }
}
