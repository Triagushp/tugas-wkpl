package org.example
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas 'Calculator' dalam namespace 'org.example'.

class Calculator {
    // Ini adalah deklarasi kelas 'Calculator' yang berfungsi sebagai kalkulator sederhana.

    fun add(first: Int, second: Int): Int {
        // Ini adalah fungsi 'add' yang digunakan untuk melakukan operasi penambahan (addisi) antara dua bilangan bulat.
        return first + second // Mengembalikan hasil penambahan dari 'first' dan 'second'.
    }

    fun sub(first: Int, second: Int): Int {
        // Ini adalah fungsi 'sub' yang digunakan untuk melakukan operasi pengurangan (subtraksi) antara dua bilangan bulat.
        return first - second // Mengembalikan hasil pengurangan 'first' dan 'second'.
    }
}
