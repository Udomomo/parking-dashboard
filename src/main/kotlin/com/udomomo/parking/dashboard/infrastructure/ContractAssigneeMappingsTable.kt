package com.udomomo.parking.dashboard.infrastructure

import org.jetbrains.exposed.v1.core.Table

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object ContractAssigneeMappingsTable : Table("contract_assignee_mappings") {
    val contractId = reference("contract_id", ContractsTable)
    val adminAccountId = reference("admin_account_id", AdminAccountsTable)

    override val primaryKey = PrimaryKey(contractId, adminAccountId)
}
