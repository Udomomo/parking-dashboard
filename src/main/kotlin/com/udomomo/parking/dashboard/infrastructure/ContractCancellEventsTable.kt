package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractCancellEventsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("contract_cancell_events") {
    val contractId = reference("contract_id", ContractsTable)
    val contractEndAt = date("contract_end_at")
    val eventDate = date("event_date")
}
