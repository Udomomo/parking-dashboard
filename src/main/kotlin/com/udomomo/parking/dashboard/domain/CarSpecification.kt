package com.udomomo.parking.dashboard.domain

class CarSpecification(
    val carNumbers: List<CarNumber>
): Specification<CarNumber> {
    override fun isSatisfied(obj: CarNumber): Boolean =
        this.carNumbers.none { it == obj }
}
