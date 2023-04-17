package com.learning.routes

import com.learning.model.Customer
import com.learning.model.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting(){
    route("/customer"){
        get{
            if (customerStorage.isEmpty()){
                return@get call.respondText("No customers exist", status = HttpStatusCode.OK)
            }else{
                return@get call.respond(customerStorage)
            }
        }

        get("{id?}"){
            val id  = call.parameters["id"] ?: return@get call.respondText("Missing id", status = HttpStatusCode.BadRequest)
            val customer = customerStorage.find { it.id == id.toInt() } ?:
            return@get call.respondText("No customer found", status = HttpStatusCode.NotFound)
            call.respond(customer)

        }

        delete("{id?}"){
            val id = call.parameters["id"] ?: return@delete call.respondText("Missing id", status = HttpStatusCode.BadRequest)
            val removeIf = customerStorage.removeIf {
                it.id == id.toInt()
            }
            if (removeIf){
                call.respondText("Customer removed", status = HttpStatusCode.OK)
            }else{
                call.respondText("Not found", status = HttpStatusCode.NotFound)
            }
        }

        post {
            val body = call.receive<Customer>()
            customerStorage.add(body)
            call.respondText("Customer stored successfully", status = HttpStatusCode.Created)
        }


    }
}