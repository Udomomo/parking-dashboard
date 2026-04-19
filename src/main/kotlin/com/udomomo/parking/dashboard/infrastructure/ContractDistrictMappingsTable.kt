package com.udomomo.parking.dashboard.infrastructure

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractDistrictMappingsTable : org.jetbrains.exposed.v1.core.Table("contract_district_mappings") {
    val districtId = reference("district_id", DistrictsTable)
    val contractId = reference("contract_id", ContractsTable)

    override val primaryKey = PrimaryKey(districtId, contractId)
}
