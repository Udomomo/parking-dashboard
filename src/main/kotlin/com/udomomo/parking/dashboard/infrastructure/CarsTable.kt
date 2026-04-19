package com.udomomo.parking.dashboard.infrastructure

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object CarsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("cars") {
    val contractId = reference("contract_id", ContractsTable)
    val number = integer("number")
    val typeNumber = integer("type_number")
}
