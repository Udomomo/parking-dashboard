package com.udomomo.parking.dashboard.infrastructure.repository

import com.udomomo.parking.dashboard.domain.Car
import com.udomomo.parking.dashboard.domain.CarNumber
import com.udomomo.parking.dashboard.domain.CarRepository
import com.udomomo.parking.dashboard.infrastructure.table.CarsTable
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.update
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class CarRepositoryImpl : CarRepository {
    override fun listByNumber(
        classification: CarNumber.Classification,
        number: CarNumber.Number
    ): List<Car> {
        return CarsTable
            .select((CarsTable.classification eq classification.value) and (CarsTable.number eq number.value.toString()))
            .map {
                Car.of(
                    id = it[CarsTable.id].value,
                    customerId = it[CarsTable.customerId].value,
                    carNumber = CarNumber.of(
                        location = CarNumber.Location(it[CarsTable.location]),
                        classification = CarNumber.Classification(it[CarsTable.classification]),
                        hiragana = CarNumber.Hiragana(it[CarsTable.hiragana]),
                        number = CarNumber.Number(it[CarsTable.number].toInt()),
                        carNumbers = emptyList(),
                    )
                )
            }
    }

    override fun findBy(uuid: Uuid): Car? {
        return CarsTable
            .select(CarsTable.id eq uuid)
            .singleOrNull()
            ?.let {
                Car.of(
                    id = it[CarsTable.id].value,
                    customerId = it[CarsTable.customerId].value,
                    carNumber = CarNumber.of(
                        location = CarNumber.Location(it[CarsTable.location]),
                        classification = CarNumber.Classification(it[CarsTable.classification]),
                        hiragana = CarNumber.Hiragana(it[CarsTable.hiragana]),
                        number = CarNumber.Number(it[CarsTable.number].toInt()),
                        carNumbers = emptyList(),
                    )
                )
            }
    }

    override fun save(car: Car) {
        val found = findBy(car.id)

        if (found != null) {
            CarsTable.update({ CarsTable.id eq car.id }) {
                it[customerId] = car.customerId
                it[location] = car.carNumber.location.value
                it[classification] = car.carNumber.classification.value
                it[hiragana] = car.carNumber.hiragana.value
                it[number] = car.carNumber.number.value.toString()
            }
            return
        }

        CarsTable.insert {
            it[id] = car.id
            it[customerId] = car.customerId
            it[location] = car.carNumber.location.value
            it[classification] = car.carNumber.classification.value
            it[hiragana] = car.carNumber.hiragana.value
            it[number] = car.carNumber.number.value.toString()
        }
    }
}