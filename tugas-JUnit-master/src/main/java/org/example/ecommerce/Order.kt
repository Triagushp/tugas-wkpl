package org.example.ecommerce
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas-kelas dalam namespace 'org.example.ecommerce'.

class Order(private val product: String, private val quantity: Int) {
    // Ini adalah deklarasi kelas 'Order'. Kelas ini mewakili pesanan dengan atribut 'product' (produk) dan 'quantity' (jumlah).

    private lateinit var warehouse: Warehouse
    // Ini adalah deklarasi variabel 'warehouse' yang akan digunakan untuk menyimpan objek 'Warehouse'.
    // Variabel ini diinisialisasi nanti saat pesanan diisi (filled).

    private var isFilled: Boolean = false
    // Ini adalah deklarasi variabel 'isFilled' yang akan digunakan untuk melacak apakah pesanan sudah diisi atau belum.
    // Nilai awalnya diatur ke 'false' karena pesanan belum diisi saat dibuat.

    fun fill(warehouse: Warehouse) {
        // Ini adalah fungsi 'fill' yang digunakan untuk mengisi pesanan dengan produk dari gudang.
        this.warehouse = warehouse // Menyimpan objek 'Warehouse' yang diberikan ke variabel 'warehouse'.
        isFilled = this.warehouse.remove(product, quantity)
        // Memanggil fungsi 'remove' dari objek 'warehouse' dengan 'product' dan 'quantity' sebagai argumen.
        // Mengupdate 'isFilled' berdasarkan hasil penghapusan produk dari gudang.
    }

    fun isFilled(): Boolean {
        // Ini adalah fungsi 'isFilled' yang digunakan untuk memeriksa apakah pesanan sudah diisi.
        return isFilled // Mengembalikan nilai 'isFilled' yang menunjukkan apakah pesanan sudah diisi atau belum.
    }
}
