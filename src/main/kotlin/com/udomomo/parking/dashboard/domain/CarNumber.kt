package com.udomomo.parking.dashboard.domain

import com.udomomo.parking.dashboard.exception.ParkingInvalidArgumentException

@ConsistentCopyVisibility
data class CarNumber private constructor(
    val location: Location,
    val classification: Classification,
    val hiragana: Hiragana,
    val number: Number,
) {
    // ナンバープレートの地名
    @JvmInline
    value class Location(
        val value: String,
    )

    // 3桁の分類番号。下2桁はアルファベットもありうる。
    @JvmInline
    value class Classification(
        val value: String,
    ) {
        init {
            require(value.matches(Regex("^[0-9][0-9A-Z]{2}$")))
        }
    }

    // ひらがな1文字
    @JvmInline
    value class Hiragana(
        val value: String,
    ) {
        init {
            require(value.matches(Regex("^[あいうえかきくけこさすせそたちつてとなにぬねのはひふほまみむめもやゆよらりるれろわを]$")))
        }
    }

    // 4桁の番号
    @JvmInline
    value class Number(
        val value: Int,
    ) {
        init {
            require(value in 1..9999)
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
            val specification = CarNumberSpecification(carNumbers)
            if (!specification.isSatisfied(carNumber)) {
                throw ParkingInvalidArgumentException()
            }

            return carNumber
        }
    }


    override fun toString() = "${location.value} ${classification.value} ${hiragana.value} ${number.value}"
}

