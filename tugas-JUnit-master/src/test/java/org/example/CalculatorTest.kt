package org.example
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas 'CalculatorTest' dalam namespace 'org.example'.

import org.junit.jupiter.api.Test
// Ini adalah impor pustaka (libraries) yang digunakan dalam pengujian.

import org.junit.jupiter.api.Assertions.*
// Ini adalah impor pustaka (libraries) yang digunakan untuk assersi dalam pengujian.

class CalculatorTest {
    // Ini adalah deklarasi kelas 'CalculatorTest' yang digunakan untuk menguji fungsi-fungsi dalam kelas 'Calculator'.

    @Test
    fun add() {
        // Ini adalah fungsi pengujian (test) yang menguji fungsi 'add' dalam kelas 'Calculator'.
        val calculator = Calculator()
        // Membuat objek kalkulator (Calculator).

        val expected = 10
        // Mendefinisikan nilai yang diharapkan dari hasil penambahan.

        assertEquals(expected, calculator.add(5, 5))
        // Memeriksa apakah hasil dari kalkulator untuk penambahan 5 dan 5 sama dengan nilai yang diharapkan (10).
    }

    @Test
    fun sub() {
        // Ini adalah fungsi pengujian (test) yang menguji fungsi 'sub' dalam kelas 'Calculator'.
        val calculator = Calculator()
        // Membuat objek kalkulator (Calculator).

        assertEquals(5, calculator.sub(15, 10))
        // Memeriksa apakah hasil dari kalkulator untuk pengurangan 15 dan 10 sama dengan nilai yang diharapkan (5).
    }
}
