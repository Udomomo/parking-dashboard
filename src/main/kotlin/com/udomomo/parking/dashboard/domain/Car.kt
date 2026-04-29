package com.udomomo.parking.dashboard.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ConsistentCopyVisibility
@OptIn(ExperimentalUuidApi::class)
data class Car private constructor(
    val id: Uuid,
    val customerId: Uuid,
    val carNumber: CarNumber,
): Entity {
    companion object {
        fun of(id: Uuid, customerId: Uuid, carNumber: CarNumber) =
            Car(id, customerId, carNumber)
    }
}
