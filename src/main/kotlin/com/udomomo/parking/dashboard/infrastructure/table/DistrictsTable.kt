package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable

object DistrictsTable : UuidTable("districts") {
    val name = varchar("name", 64)
    val parkId = reference("park_id", ParksTable)
    val number = integer("number")
}
