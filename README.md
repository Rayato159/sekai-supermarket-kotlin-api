<h1>🥪 Sekai Supermarket CRUD with Micronaut [Kotlin]</h1>
<p>This is just a practice to do a backend service using <strong>Kotlin Micronaut</strong> framework</p>

<h2>📝 API Lists</h2>
<ul>
    <li>GET /product -> Find products</li>
    <li>GET /product/:productId -> Find product by id</li>
    <li>POST /product -> Add new product</li>
    <li>PATCH /product/:productId -> Update product by id</li>
    <li>DELETE /product/:productId -> Delete product by id</li>
</ul>

<h2>📦 Product Data Class</h2>

```kotlin
@Introspected
@Serdeable
data class Product(

    @JsonProperty("id")
    var id: String? = "",

    @JsonProperty("title")
    var title: String,

    @JsonProperty("description")
    var description: String,
)
```