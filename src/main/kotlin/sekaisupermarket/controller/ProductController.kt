package sekaisupermarket.controller

import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import sekaisupermarket.mock.ProductFaker
import sekaisupermarket.model.Either
import sekaisupermarket.model.ErrResponse
import sekaisupermarket.model.Product
import sekaisupermarket.service.ProductService

@Controller("/product")
class ProductController @Inject constructor(private val productService: ProductService) {
    @Post("/")
    @SingleResult
    fun addProduct(
        @Body req: Product
    ): HttpResponse<*> {
        return HttpResponse.created(productService.insertProduct(req))
    }

    @Get("/")
    @SingleResult
    fun findProducts(): HttpResponse<*> {
        return HttpResponse.ok(productService.findProducts())
    }

    @Get("/{productId}")
    @SingleResult
    fun findProductById(
        @PathVariable productId: String
    ): HttpResponse<*> {
        return when (val result: Either<String, Product> = productService.findOneProduct(productId)) {
            is Either.Left -> HttpResponse.ok(ErrResponse(result.value))
            is Either.Right -> HttpResponse.ok(result.value)
        }
    }

    @Patch("/{productId}")
    @SingleResult
    fun findProductById(
        @PathVariable productId: String,
        @Body req: Product
    ): HttpResponse<*> {
        return when (val result: Either<String, Product> = productService.updateProduct(productId, req)) {
            is Either.Left -> HttpResponse.ok(ErrResponse(result.value))
            is Either.Right -> HttpResponse.ok(result.value)
        }
    }

    @Delete("/{productId}")
    @SingleResult
    fun deleteOne(
        @PathVariable productId: String
    ): HttpResponse<*> {
        return when (val result: Either<String, Product> = productService.deleteProduct(productId)) {
            is Either.Left -> HttpResponse.ok(ErrResponse(result.value))
            is Either.Right -> HttpResponse.ok(result.value)
        }
    }
}