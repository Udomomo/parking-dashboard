package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.Table

object ContractDistrictMappingsTable : Table("contract_district_mappings") {
    val districtId = reference("district_id", DistrictsTable)
    val contractId = reference("contract_id", ContractsTable)

    override val primaryKey = PrimaryKey(districtId, contractId)
}
