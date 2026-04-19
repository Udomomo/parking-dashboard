package com.udomomo.parking.dashboard.infrastructure

object AdminAccountsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("admin_accounts") {
    val email = varchar("email", 128)
    val password = varchar("password", 256)
    val status = varchar("status", 16)
}

