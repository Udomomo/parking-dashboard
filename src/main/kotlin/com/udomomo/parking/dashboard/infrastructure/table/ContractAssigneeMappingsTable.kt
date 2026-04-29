package com.udomomo.parking.dashboard.infrastructure.table

import org.jetbrains.exposed.v1.core.Table

object ContractAssigneeMappingsTable : Table("contract_assignee_mappings") {
    val contractId = reference("contract_id", ContractsTable)
    val adminAccountId = reference("admin_account_id", AdminAccountsTable)

    override val primaryKey = PrimaryKey(contractId, adminAccountId)
}
