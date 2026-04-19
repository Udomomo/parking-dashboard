package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractDistrictEventsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("contract_district_events") {
    val contractId = reference("contract_id", ContractsTable)
    val eventType = varchar("event_type", 16)
    val districtId = reference("district_id", DistrictsTable)
    val eventDate = date("event_date")
}
