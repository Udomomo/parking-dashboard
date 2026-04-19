package com.udomomo.parking.dashboard.domain

class CarNumberSpecification(
    val carNumbers: List<CarNumber>
): Specification<CarNumber> {
    override fun isSatisfied(obj: CarNumber): Boolean =
        this.carNumbers.none { it == obj }
}
