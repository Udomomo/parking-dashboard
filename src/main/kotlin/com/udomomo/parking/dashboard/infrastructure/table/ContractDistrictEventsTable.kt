package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
object ContractDistrictEventsTable : UuidTable("contract_district_events") {
    val contractId = reference("contract_id", ContractsTable)
    val eventType = varchar("event_type", 16)
    val districtId = reference("district_id", DistrictsTable)
    val eventDate = date("event_date")
}
