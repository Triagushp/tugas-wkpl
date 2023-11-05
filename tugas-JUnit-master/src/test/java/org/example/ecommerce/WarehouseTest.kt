package org.example.ecommerce
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas 'OrderStateTest' dalam namespace 'org.example.ecommerce'.

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
// Ini adalah impor pustaka (libraries) yang digunakan dalam pengujian.

class OrderStateTest {
    // Ini adalah deklarasi kelas 'OrderStateTest' yang digunakan untuk menguji status pesanan (Order) dalam hubungannya dengan gudang (Warehouse).

    private val LAPTOP = "Macbook"
    private val MOUSE = "Logitech Mouse"
    private val warehouse = Warehouse()
    // Ini adalah deklarasi beberapa konstanta dan objek gudang (Warehouse) yang akan digunakan dalam pengujian.

    @BeforeEach
    fun setUp() {
        // Ini adalah fungsi yang dipanggil sebelum setiap pengujian (test) untuk menyiapkan kondisi awal.
        warehouse.add(LAPTOP, 50)
        warehouse.add(MOUSE, 20)
        // Menambahkan produk "Macbook" sebanyak 50 dan "Logitech Mouse" sebanyak 20 ke gudang.
    }

    @Test
    fun `test order is fulfilled if capacity in warehouse is sufficient`() {
        // Ini adalah fungsi pengujian (test) yang menguji apakah pesanan terisi jika kapasitas gudang mencukupi.
        val order = Order(LAPTOP, 20)
        // Membuat pesanan (Order) untuk produk "Macbook" sebanyak 20.

        order.fill(warehouse)
        // Mengisi pesanan dengan gudang (Warehouse).

        assertTrue(order.isFilled())
        // Memastikan bahwa pesanan terisi.

        assertEquals(30, warehouse.getInventory(LAPTOP))
        // Memeriksa apakah jumlah "Macbook" di gudang berkurang menjadi 30 setelah pesanan terisi.
    }

    @Test
    fun `test order is not fulfilled if capacity in warehouse is insufficient`() {
        // Ini adalah fungsi pengujian (test) yang menguji apakah pesanan tidak terisi jika kapasitas gudang tidak mencukupi.
        val order = Order(MOUSE, 21)
        // Membuat pesanan (Order) untuk produk "Logitech Mouse" sebanyak 21.

        order.fill(warehouse)
        // Mengisi pesanan dengan gudang (Warehouse).

        assertFalse(order.isFilled())
        // Memastikan bahwa pesanan tidak terisi.

        assertEquals(20, warehouse.getInventory(MOUSE))
        // Memeriksa apakah jumlah "Logitech Mouse" di gudang tetap 20 setelah pesanan tidak terisi.
    }
}
