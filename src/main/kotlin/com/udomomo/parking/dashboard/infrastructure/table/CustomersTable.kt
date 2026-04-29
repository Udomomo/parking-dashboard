package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable

object CustomersTable : UuidTable("customers") {
    val name = varchar("name", 64)
    val address = varchar("address", 256)
    val phoneNumber = varchar("phone_number", 32)
}
