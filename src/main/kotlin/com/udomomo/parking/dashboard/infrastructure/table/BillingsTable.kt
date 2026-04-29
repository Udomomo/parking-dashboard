package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import org.jetbrains.exposed.v1.datetime.date

object BillingsTable : UuidTable("billings") {
    val contractId = reference("contract_id", ContractsTable)
    val price = integer("price")
    val periodStartAt = date("period_start_at")
    val periodEndAt = date("period_end_at")
    val dueDate = date("due_date")
    val status = varchar("status", 16)
}
