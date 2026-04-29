package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.datetime.date

object BillingRevertEventsTable : Table("billing_revert_events") {
    val billingId = reference("billing_id", BillingsTable)
    val eventDate = date("event_date")
}
