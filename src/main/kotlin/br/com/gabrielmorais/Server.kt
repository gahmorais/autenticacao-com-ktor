package br.com.gabrielmorais

import br.com.gabrielmorais.auth.auth
import br.com.gabrielmorais.routes.userRoutes
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) = EngineMain.main(args)

@Suppress("unused")
fun Application.server() {
  auth()
  userRoutes()
  routing {
    get("/") {
      call.respondText("Hello World!")
    }

  }
}