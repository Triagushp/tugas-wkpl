package org.example.ecommerce
// Ini adalah deklarasi paket (package) yang digunakan untuk mengelompokkan kelas-kelas dalam namespace 'org.example.ecommerce'.

class Warehouse {
    // Ini adalah deklarasi kelas 'Warehouse' yang merepresentasikan gudang atau tempat penyimpanan produk.

    private val warehouse: HashMap<String, Int> = hashMapOf()
    // Ini adalah deklarasi variabel 'warehouse' yang merupakan objek HashMap untuk menyimpan produk dan jumlahnya.
    // Produk direpresentasikan dengan String (nama produk), dan jumlahnya dengan Int.

    fun add(product: String, quantity: Int) {
        // Ini adalah fungsi 'add' yang digunakan untuk menambahkan produk ke gudang beserta jumlahnya.
        warehouse[product] = quantity
        // Menambahkan produk ke gudang dengan jumlah yang ditentukan.
    }

    fun remove(product: String, quantity: Int): Boolean {
        // Ini adalah fungsi 'remove' yang digunakan untuk menghapus produk dari gudang berdasarkan nama produk dan jumlah yang diinginkan.
        if (warehouse.contains(product).not()) {
            // Jika produk tidak ditemukan dalam gudang, cetak pesan kesalahan dan kembalikan 'false'.
            println("Product not found in warehouse")
            return false
        }

        if (warehouse[product] == 0) {
            // Jika jumlah produk dalam gudang adalah 0, cetak pesan kesalahan dan kembalikan 'false'.
            println("No items for this product in the warehouse")
            return false
        }

        if (warehouse[product]!! < quantity) {
            // Jika jumlah produk dalam gudang kurang dari jumlah yang diminta, cetak pesan kesalahan dan kembalikan 'false'.
            println("Not enough items in the warehouse")
            return false
        }

        val currentQty = warehouse[product]
        val newQty = currentQty!!.minus(quantity)
        warehouse[product] = newQty
        // Mengurangi jumlah produk dalam gudang sesuai dengan jumlah yang diminta.
        return true // Mengembalikan 'true' untuk menandakan penghapusan berhasil.
    }

    fun getInventory(product: String): Int? {
        // Ini adalah fungsi 'getInventory' yang digunakan untuk mendapatkan jumlah produk dalam gudang berdasarkan nama produk.
        return warehouse.get(product) // Mengembalikan jumlah produk atau 'null' jika produk tidak ditemukan.
    }
}
