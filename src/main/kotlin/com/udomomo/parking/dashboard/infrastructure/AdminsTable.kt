package com.udomomo.parking.dashboard.infrastructure

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
object AdminsTable : org.jetbrains.exposed.v1.core.dao.id.UuidTable("admins") {
    val adminAccountId = reference("admin_account_id", AdminAccountsTable)
    val name = varchar("name", 64)
    val code = varchar("code", 32)
}
