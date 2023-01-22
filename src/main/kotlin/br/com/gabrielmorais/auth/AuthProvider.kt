package br.com.gabrielmorais.auth

import io.ktor.server.auth.*
import io.ktor.util.*

object AuthProvider {
  private const val DEFAULT_USERNAME = "teste"
  private const val DEFAULT_PASSWORD = "123456"

  private val digestFunction = getDigestFunction("SHA-256") {
    "ktor${it.length}"
  }

  private val hashedUserTable = UserHashedTableAuth(
    table = mapOf(
      DEFAULT_USERNAME to digestFunction(DEFAULT_PASSWORD),
    ), digester = digestFunction
  )

  fun tryAuth(credentials: UserPasswordCredential) = hashedUserTable.authenticate(credentials)

}