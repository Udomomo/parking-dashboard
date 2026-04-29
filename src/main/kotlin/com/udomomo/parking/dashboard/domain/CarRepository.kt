package com.udomomo.parking.dashboard.domain

import kotlin.uuid.Uuid

interface CarRepository {
    fun listByNumber(classification: CarNumber.Classification, number: CarNumber.Number): List<Car>

    fun findBy(uuid: Uuid): Car?

    fun save(car: Car)
}