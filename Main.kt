import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

// 1. Data Class untuk merepresentasikan objek produk dari JSON
data class Product(
    @SerializedName("product_id") 
    val productId: String,
    
    @SerializedName("product_name") 
    val productName: String,
    
    val price: Int,
    
    @SerializedName("is_available") 
    val isAvailable: Boolean
)

// 2. Fungsi utama
fun main() {
    // String JSON sesuai dengan soal tugas
    val jsonString = """
        [
            {
                "product_id": "P001",
                "product_name": "Laptop Gaming X",
                "price": 15000000,
                "is_available": true
            },
            {
                "product_id": "P002",
                "product_name": "Mouse Wireless",
                "price": 250000,
                "is_available": false
            },
            {
                "product_id": "P003",
                "product_name": "Keyboard Mechanical",
                "price": 750000,
                "is_available": true
            }
        ]
    """.trimIndent()

    // Inisialisasi Gson
    val gson = Gson()
    
    // Mengonversi string JSON menjadi List of Product
    val listType = object : TypeToken<List<Product>>() {}.type
    val productList: List<Product> = gson.fromJson(jsonString, listType)

    // Melakukan perulangan dan menyaring produk yang is_available = true
    productList.forEach { product ->
        if (product.isAvailable) {
            // Mencetak output sesuai format yang diminta di soal
            println("Produk Tersedia: [${product.productName}] dengan harga Rp [${product.price}]")
        }
    }
}
