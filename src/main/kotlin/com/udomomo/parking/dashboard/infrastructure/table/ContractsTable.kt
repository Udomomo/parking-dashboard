package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
object ContractsTable : UuidTable("contracts") {
    val customerId = reference("customer_id", CustomersTable)
    val startAt = date("start_at")
    val endAt = date("end_at").nullable()
}
