package com.udomomo.parking.dashboard.domain

import com.udomomo.parking.dashboard.exception.ParkingInvalidArgumentException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNumberTest {
    @Test
    fun `should create a valid car number`() {
        // Arrange
        val location = CarNumber.Location("品川")
        val classification = CarNumber.Classification("30A")
        val hiragana = CarNumber.Hiragana("ま")
        val number = CarNumber.Number(1234)

        // Act
        val result = runCatching {
            CarNumber.of(location, classification, hiragana, number, carNumbers = emptyList())
        }.getOrNull()

        Assertions.assertThat(result).isNotNull()
    }

    @Test
    fun `should not create a car number when same number exists`() {
        // Arrange
        val location = CarNumber.Location("品川")
        val classification = CarNumber.Classification("30A")
        val hiragana = CarNumber.Hiragana("ま")
        val number = CarNumber.Number(1234)

        val existingCarNumber = CarNumber.of(location, classification, hiragana, number, carNumbers = emptyList())

        // Act & Assert
        Assertions.assertThatThrownBy {
            CarNumber.of(location, classification, hiragana, number, carNumbers = listOf(existingCarNumber))
        }.isExactlyInstanceOf(ParkingInvalidArgumentException::class.java)
    }

    @Nested
    inner class Location {
        @Test
        fun `should create a valid location`() {
            // Arrange
            val location = "愛知"

            // Act
            val result = runCatching {
                CarNumber.Location(location)
            }.getOrNull()

            // Assert
            Assertions.assertThat(result).isNotNull()

        }

        @ParameterizedTest
        @ValueSource(strings = [
            "",
            " ",
            "　 ",
        ])
        fun `should not create a blank location`(input: String) {
            Assertions.assertThatThrownBy {
                CarNumber.Location(input)
            }.isExactlyInstanceOf(ParkingInvalidArgumentException::class.java)
        }
    }

    @Nested
    inner class Classification {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "123",
                "24Z"
            ]
        )
        fun `should create a valid classification`(input: String) {
            val result = runCatching {
                CarNumber.Classification(input)
            }.getOrNull()
            Assertions.assertThat(result).isNotNull()
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "分類", // 英数でない
                "1234", // 3桁でない
                "ABC", // 最初の1桁が数字でない
            ]
        )
        fun `should not create an invalid classification`(input: String) {
            Assertions.assertThatThrownBy {
                CarNumber.Classification(input)
            }.isExactlyInstanceOf(ParkingInvalidArgumentException::class.java)
        }
    }

    @Nested
    inner class Hiragana {
        @Test
        fun `should create a valid hiragana`() {
            // Arrange
            val hiragana = "あ"

            // Act
            val result = runCatching {
                CarNumber.Hiragana(hiragana)
            }.getOrNull()

            // Assert
            Assertions.assertThat(result).isNotNull()
        }

        @ParameterizedTest
        @ValueSource(strings = [
            "あいう",
            "1",
            "安",
            ""
        ])
        fun `should not create an invalid hiragana`(input: String) {
            Assertions.assertThatThrownBy {
                CarNumber.Hiragana(input)
            }.isExactlyInstanceOf(ParkingInvalidArgumentException::class.java)
        }
    }

    @Nested
    inner class Number {
        @ParameterizedTest
        @ValueSource(ints = [
            1,
            500,
            9999,
        ])
        fun `should create a valid number`(input: Int) {
            // Act
            val result = runCatching {
                CarNumber.Number(input)
            }.getOrNull()

            // Assert
            Assertions.assertThat(result).isNotNull()
        }

        @ParameterizedTest
        @ValueSource(ints = [
            -1,
            0,
            10000,
        ])
        fun `should not create an invalid number`(input: Int) {
            Assertions.assertThatThrownBy {
                CarNumber.Number(input)
            }.isExactlyInstanceOf(ParkingInvalidArgumentException::class.java)
        }
    }
}