package com.udomomo.parking.dashboard.domain

interface CarNumberRepository {
    fun findBy(classification: CarNumber.Classification, number: CarNumber.Number): CarNumber?
}