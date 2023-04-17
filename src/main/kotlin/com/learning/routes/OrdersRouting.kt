package com.learning.routes

import com.learning.model.ordersStroage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrdersRoute(){
    get("/orders"){
        if (ordersStroage.isEmpty()){
            return@get call.respondText("Empty orders", status = HttpStatusCode.OK)
        }else{
            return@get call.respond(ordersStroage)
        }
    }
}

fun Route.getOrderRoute(){
    get("/orders/{id?}"){
        val id = call.parameters["id"] ?: return@get call.respondText("Missing order number", status = HttpStatusCode.BadRequest)
        val order = ordersStroage.find { it.number == id } ?: return@get call.respondText("No order found", status = HttpStatusCode.NotFound)

        call.respond(order)
    }
}

fun Route.getOrderTotal(){
    get("/orders/{id?}/total"){
        val id = call.parameters["id"] ?: return@get call.respondText("Missing order number", status = HttpStatusCode.BadRequest)
        val order = ordersStroage.find { it.number == id } ?: return@get call.respondText("No order exist with number : $id", status = HttpStatusCode.NotFound)

        val total = order.orderItems.sumOf {
            it.count * it.price
        }

        call.respond(total)

    }
}