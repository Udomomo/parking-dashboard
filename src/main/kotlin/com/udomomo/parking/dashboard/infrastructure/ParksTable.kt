package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.core.dao.id.UuidTable

object ParksTable : UuidTable("parks") {
    val name = varchar("name", 64)
    val address = varchar("address", 128)
}