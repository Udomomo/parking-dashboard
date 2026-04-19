package com.udomomo.parking.dashboard.infrastructure

object ParksTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("parks") {
    val name = varchar("name", 64)
    val address = varchar("address", 128)
}