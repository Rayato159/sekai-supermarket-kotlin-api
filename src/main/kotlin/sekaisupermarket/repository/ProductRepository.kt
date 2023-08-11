package sekaisupermarket.repository

import jakarta.inject.Singleton
import sekaisupermarket.mock.ProductFaker
import sekaisupermarket.model.Either
import sekaisupermarket.model.Product

@Singleton
class ProductRepository {
    private val mockDb: ProductFaker = ProductFaker

    fun insertProduct(req: Product): Product {
        return mockDb.insertOne(req)
    }

    fun findProducts(): List<Product> {
        return mockDb.find()
    }

    fun findOneProduct(productId: String): Either<String, Product> {
        return mockDb.findOne(productId)
    }

    fun updateProduct(productId: String, product: Product): Either<String, Product> {
        return mockDb.updateOne(productId, product)
    }

    fun deleteProduct(productId: String): Either<String, Product> {
        return mockDb.deleteOne(productId)
    }
}