package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object BillingRevertEventsTable : org.jetbrains.exposed.v1.core.Table("billing_revert_events") {
    val billingId = reference("billing_id", BillingsTable)
    val eventDate = date("event_date")
}
