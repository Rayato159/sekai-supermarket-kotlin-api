package sekaisupermarket.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

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