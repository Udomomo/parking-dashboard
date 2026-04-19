package com.udomomo.parking.dashboard.infrastructure

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractAssigneeMappingsTable : org.jetbrains.exposed.v1.core.Table("contract_assignee_mappings") {
    val contractId = reference("contract_id", ContractsTable)
    val adminAccountId = reference("admin_account_id", AdminAccountsTable)

    override val primaryKey = PrimaryKey(contractId, adminAccountId)
}
