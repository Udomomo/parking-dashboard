package com.udomomo.parking.dashboard.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface CarRepository {
    fun listByNumber(classification: CarNumber.Classification, number: CarNumber.Number): List<Car>

    @OptIn(ExperimentalUuidApi::class)
    fun findBy(uuid: Uuid): Car?

    fun save(car: Car)
}