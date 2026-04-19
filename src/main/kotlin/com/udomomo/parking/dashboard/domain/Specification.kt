package com.udomomo.parking.dashboard.domain

interface Specification<T> {
    fun isSatisfied(obj: T): Boolean
}