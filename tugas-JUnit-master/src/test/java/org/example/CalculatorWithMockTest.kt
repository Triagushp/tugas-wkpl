package org.example
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas 'CalculatorWithMockTest' dalam namespace 'org.example'.

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.opentest4j.AssertionFailedError
import kotlin.test.assertEquals
// Ini adalah impor pustaka (libraries) yang digunakan dalam pengujian.

class CalculatorWithMockTest {
    // Ini adalah deklarasi kelas 'CalculatorWithMockTest' yang digunakan untuk menguji fungsi 'Calculator' dengan penggunaan objek palsu (mock).

    @Test
    fun `test mock calculator add method returns mocked value`() {
        // Ini adalah fungsi pengujian (test) yang menguji apakah metode 'add' pada objek kalkulator palsu (mock) mengembalikan nilai yang sudah dimock.
        // Mari kita buat objek kalkulator palsu (mock).
        val mockCalculator = mock(Calculator::class.java)
        // Mengganti perilaku default objek kalkulator palsu (mock).
        `when`(mockCalculator.add(5, 5)).thenReturn(20)

        val actual = mockCalculator.add(5, 5)
        // Memanggil metode 'add' pada objek kalkulator palsu.
        println("Actual result from mock: $actual")
        assertEquals(expected = 20, actual)
        // Memeriksa apakah hasil yang dikembalikan oleh objek kalkulator palsu sesuai dengan nilai yang dimock (20).
    }

    @Test
    fun `test mock calculator add method does not return a value for unhandled case`() {
        // Ini adalah fungsi pengujian (test) yang menguji apakah metode 'add' pada objek kalkulator palsu (mock) tidak mengembalikan nilai untuk kasus yang tidak ditangani.
        // Mari kita buat objek kalkulator palsu (mock).
        val mockCalculator = mock(Calculator::class.java)
        // Mengganti perilaku default objek kalkulator palsu (mock).
        `when`(mockCalculator.add(5, 5)).thenReturn(20)

        val actual = mockCalculator.add(5, 10)
        // Memanggil metode 'add' pada objek kalkulator palsu.
        println("Actual result from mock: $actual")
        assertThrows<AssertionFailedError> { assertEquals(expected = 15, actual) }
        // Memeriksa bahwa metode 'add' tidak mengembalikan nilai yang dimock (kasus yang tidak ditangani), dan ini menyebabkan pengecualian (AssertionFailedError) saat mencoba membandingkannya dengan nilai yang diharapkan (15).
    }
}
