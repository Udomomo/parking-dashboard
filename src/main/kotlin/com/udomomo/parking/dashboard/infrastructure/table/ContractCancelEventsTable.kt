package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date

object ContractCancelEventsTable : UuidTable("contract_cancel_events") {
    val contractId = reference("contract_id", ContractsTable)
    val contractEndAt = date("contract_end_at")
    val eventDate = date("event_date")
}
