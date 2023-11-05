package org.example.ecommerce
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas 'OrderInteractionTest' dalam namespace 'org.example.ecommerce'.

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
// Ini adalah impor pustaka (libraries) yang digunakan dalam pengujian.

class OrderInteractionTest {
    // Ini adalah deklarasi kelas 'OrderInteractionTest' yang digunakan untuk menguji interaksi antara objek 'Order' dan 'Warehouse'.

    private val LAPTOP = "Macbook"
    // Ini adalah deklarasi konstanta 'LAPTOP' dengan nilai "Macbook", yang digunakan dalam pengujian.

    @Test
    fun `test warehouse capacity is reduced on fulfilling order`() {
        // Ini adalah fungsi pengujian (test) yang mengevaluasi apakah kapasitas gudang berkurang saat pesanan dipenuhi.
        val order = Order(LAPTOP, 50)
        // Membuat objek 'Order' dengan produk "Macbook" dan jumlah 50.

        val warehouseMock = mock(Warehouse::class.java)
        // Membuat objek mock (palsu) dari kelas 'Warehouse' untuk simulasi.

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(0)
        // Ketika memanggil 'getInventory' dengan produk "Macbook", maka kembalikan nilai 0.

        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(true)
        // Ketika memanggil 'remove' dengan produk "Macbook" dan jumlah 50, maka kembalikan 'true'.

        order.fill(warehouseMock)
        // Mengisi pesanan dengan objek mock gudang.

        assertTrue(order.isFilled())
        // Memastikan bahwa pesanan telah terisi.

        assertEquals(0, warehouseMock.getInventory(LAPTOP))
        // Memeriksa apakah kapasitas gudang telah berkurang menjadi 0 setelah pesanan terisi.
    }

    @Test
    fun `test warehouse capacity is not reduced when order cannot be fulfilled`() {
        // Ini adalah fungsi pengujian (test) yang mengevaluasi apakah kapasitas gudang tidak berkurang saat pesanan tidak dapat dipenuhi.
        val order = Order(LAPTOP, 51)
        // Membuat objek 'Order' dengan produk "Macbook" dan jumlah 51.

        val warehouseMock = mock(Warehouse::class.java)
        // Membuat objek mock (palsu) dari kelas 'Warehouse' untuk simulasi.

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(50)
        // Ketika memanggil 'getInventory' dengan produk "Macbook", maka kembalikan nilai 50.

        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(false)
        // Ketika memanggil 'remove' dengan produk "Macbook" dan jumlah 50, maka kembalikan 'false'.

        order.fill(warehouseMock)
        // Mengisi pesanan dengan objek mock gudang.

        assertFalse(order.isFilled())
        // Memastikan bahwa pesanan tidak terisi.

        assertEquals(50, warehouseMock.getInventory(LAPTOP))
        // Memeriksa apakah kapasitas gudang tetap 50 setelah pesanan tidak dapat dipenuhi.
    }
}
