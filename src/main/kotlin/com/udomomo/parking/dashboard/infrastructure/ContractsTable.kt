package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("contracts") {
    val customerId = reference("customer_id", CustomersTable)
    val startAt = date("start_at")
    val endAt = date("end_at").nullable()
}
