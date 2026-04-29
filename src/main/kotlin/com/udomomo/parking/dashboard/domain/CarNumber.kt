package com.udomomo.parking.dashboard.domain

import com.udomomo.parking.dashboard.exception.ParkingInvalidArgumentException

@ConsistentCopyVisibility
data class CarNumber private constructor(
    val location: Location,
    val classification: Classification,
    val hiragana: Hiragana,
    val number: Number,
): ValueObject {
    // ナンバープレートの地名
    @JvmInline
    value class Location(
        val value: String,
    ) {
        init {
            if (value.isBlank()) {
                throw ParkingInvalidArgumentException("Location cannot be blank")
            }
        }
    }

    // 3桁の分類番号。下2桁はアルファベットもありうる。
    @JvmInline
    value class Classification(
        val value: String,
    ) {
        init {
            if (!value.matches(Regex("^[0-9][0-9A-Z]{2}$"))) {
                throw ParkingInvalidArgumentException("invalid classification | $value")
            }
        }
    }

    // ひらがな1文字
    @JvmInline
    value class Hiragana(
        val value: String,
    ) {
        init {
            if (!value.matches(Regex("^[あいうえかきくけこさすせそたちつてとなにぬねのはひふほまみむめもやゆよらりるれろわを]$"))) {
                throw ParkingInvalidArgumentException("invalid Hiragana | $value")
            }
        }
    }

    // 4桁の番号
    @JvmInline
    value class Number(
        val value: Int,
    ) {
        init {
            if (value !in 1..9999) {
                throw ParkingInvalidArgumentException("invalid number | $value")
            }
        }
    }

    companion object {
        fun of(
            location: Location,
            classification: Classification,
            hiragana: Hiragana,
            number: Number,
            carNumbers: List<CarNumber>
        ): CarNumber {
            val carNumber = CarNumber(location, classification, hiragana, number)

            val specification = CarSpecification(carNumbers)
            if (!specification.isSatisfied(carNumber)) {
                throw ParkingInvalidArgumentException("Car number specification is not satisfied")
            }

            return carNumber
        }
    }


    override fun toString() = "${location.value} ${classification.value} ${hiragana.value} ${number.value}"
}

