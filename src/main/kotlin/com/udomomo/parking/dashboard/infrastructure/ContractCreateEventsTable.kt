package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractCreateEventsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("contract_create_events") {
    val contractId = reference("contract_id", ContractsTable)
    val contractStartAt = date("contract_start_at")
    val eventDate = date("event_date")
}
