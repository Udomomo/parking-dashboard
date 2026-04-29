package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date

object ContractCreateEventsTable : UuidTable("contract_create_events") {
    val contractId = reference("contract_id", ContractsTable)
    val contractStartAt = date("contract_start_at")
    val eventDate = date("event_date")
}
