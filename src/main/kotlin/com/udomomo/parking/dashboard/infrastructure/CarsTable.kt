package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.core.dao.id.UuidTable

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object CarsTable : UuidTable("cars") {
    val location = varchar("location", 8)
    val classification = varchar("classification", 3)
    val hiragana = varchar("hiragana", 1)
    val number = varchar("number", 4)
}
