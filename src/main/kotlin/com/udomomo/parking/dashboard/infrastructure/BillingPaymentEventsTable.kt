package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.datetime.date

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object BillingPaymentEventsTable : Table("billing_payment_events") {
    val billingId = reference("billing_id", BillingsTable)
    val eventDate = date("event_date")
}
