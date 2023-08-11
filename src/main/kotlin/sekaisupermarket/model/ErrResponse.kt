package sekaisupermarket.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
data class ErrResponse(
    var message: String
)