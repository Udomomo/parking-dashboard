package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date

object ContractCarEventsTable : UuidTable("contract_car_events") {
    val contractId = reference("contract_id", ContractsTable)
    val eventType = varchar("event_type", 16)
    val carId = reference("car_id", CarsTable)
    val eventDate = date("event_date")
}
