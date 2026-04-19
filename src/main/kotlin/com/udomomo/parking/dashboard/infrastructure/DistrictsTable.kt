package com.udomomo.parking.dashboard.infrastructure

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object DistrictsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("districts") {
    val name = varchar("name", 64)
    val parkId = reference("park_id", ParksTable)
    val number = integer("number")
}

