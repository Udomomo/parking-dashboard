package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
object CarsTable : UuidTable("cars") {
    val customerId = reference("customer_id", CustomersTable)
    val location = varchar("location", 8)
    val classification = varchar("classification", 3)
    val hiragana = varchar("hiragana", 1)
    val number = varchar("number", 4)
}
