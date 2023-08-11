package sekaisupermarket.mock

import jakarta.inject.Singleton
import sekaisupermarket.model.Product
import sekaisupermarket.model.Either

@Singleton
object ProductFaker {
    private val products: MutableList<Product> = mutableListOf(
        Product(
            "P-000001",
            "Water",
            "Pure water"
        ),
        Product(
            "P-000002",
            "Potato",
            "Fresh potato"
        ),
        Product(
            "P-000003",
            "Juice",
            "Fresh orange juice"
        ),
        Product(
            "P-000004",
            "Milk",
            "Whole milk"
        ),
        Product(
            "P-000005",
            "Soda",
            "Cola flavor"
        )
    )

    fun insertOne(product: Product): Product {
        val latestId = 5
        val newProductId = "P-${(latestId + 1).toString().padStart(6, '0')}"

        product.id = newProductId
        products.add(product)

        return product
    }

    fun find(): List<Product> {
        return products.toList()
    }

    fun findOne(productId: String): Either<String, Product> {
        val product = products.find { it.id == productId }
        return if (product != null) {
            Either.Right(product)
        } else {
            Either.Left("Error: Product id: $productId not found.")
        }
    }

    fun updateOne(productId: String, product: Product): Either<String, Product> {
        val updatedProductIndex = products.indexOfFirst { it.id == productId }
        return if (updatedProductIndex != -1) {
            val existingProduct = products[updatedProductIndex]

            val updatedTitle = product.title.takeIf { it.isNotEmpty() } ?: existingProduct.title
            val updatedDescription = product.description.takeIf { it.isNotEmpty() } ?: existingProduct.description

            val updatedProduct = existingProduct.copy(title = updatedTitle, description = updatedDescription)

            products[updatedProductIndex] = updatedProduct

            Either.Right(updatedProduct)
        } else {
            Either.Left("Error: Product id: $productId not found.")
        }
    }

    fun deleteOne(productId: String): Either<String, Product> {
        val deletedProductIndex = products.indexOfFirst { it.id == productId }

        return if (deletedProductIndex != -1) {
            val existingProduct = products[deletedProductIndex]
            products.removeAt(deletedProductIndex)
            Either.Right(existingProduct)
        } else {
            Either.Left("Error: Product id: $productId not found.")
        }
    }
}
