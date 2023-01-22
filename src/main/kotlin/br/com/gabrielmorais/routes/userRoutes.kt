package br.com.gabrielmorais.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRoutes() = routing {
  authenticate {
    getUsers()
  }
}


fun Route.getUsers() = get("/users") {
  call.respondText("Retornando usuários")
}