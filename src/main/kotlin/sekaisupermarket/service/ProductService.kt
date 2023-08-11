package sekaisupermarket.service

import jakarta.inject.Inject
import jakarta.inject.Singleton
import sekaisupermarket.model.Either
import sekaisupermarket.model.Product
import sekaisupermarket.repository.ProductRepository

@Singleton
class ProductService @Inject constructor(private val productRepository: ProductRepository) {
    fun insertProduct(req: Product): Product {
        return productRepository.insertProduct(req)
    }

    fun findProducts(): List<Product> {
        return productRepository.findProducts()
    }

    fun findOneProduct(productId: String): Either<String, Product> {
        return productRepository.findOneProduct(productId)
    }

    fun updateProduct(productId: String, product: Product): Either<String, Product> {
        return productRepository.updateProduct(productId, product)
    }

    fun deleteProduct(productId: String): Either<String, Product> {
        return productRepository.deleteProduct(productId)
    }
}