package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractCarEventsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("contract_car_events") {
    val contractId = reference("contract_id", ContractsTable)
    val eventType = varchar("event_type", 16)
    val carId = reference("car_id", CarsTable)
    val eventDate = date("event_date")
}
