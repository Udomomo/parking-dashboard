package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.datetime

object CarVerificationEventsTable : UuidTable("car_verification_events") {
    val carId = reference("car_id", CarsTable)
    val status = varchar("status", 16)
    val eventAt = datetime("event_at")
}
