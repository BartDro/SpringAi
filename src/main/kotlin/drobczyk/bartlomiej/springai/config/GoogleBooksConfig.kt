package drobczyk.bartlomiej.springai.config


import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "google-books")
data class GoogleBooksProperties(
    var api: ApiProperties = ApiProperties(),
    var genres: Map<String, String> = emptyMap()
) {
    data class ApiProperties(
        var url: String = "",
        var key: String = ""
    )
}