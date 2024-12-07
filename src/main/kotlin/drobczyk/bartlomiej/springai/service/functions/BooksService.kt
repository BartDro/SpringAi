package drobczyk.bartlomiej.springai.service.functions

import drobczyk.bartlomiej.springai.config.GoogleBooksProperties
import org.springframework.web.client.RestClient
import java.util.function.Function

class BooksService(
    private val booksProperties: GoogleBooksProperties,
    private val restClient: RestClient
) : Function<BooksService.Request, String> {

    override fun apply(request: Request): String {
        return restClient.get()
            .uri(buildUrl(request))
            .retrieve()
            .body(String::class.java) ?: "Could not fetch books data for $request"
    }

    //Kotlin curio: thanks that we can use bean as booksService(Request("sci-fi")) without explicit "apply" call
    operator fun invoke(request: Request): String {
        return apply(request)
    }

    private fun buildUrl(request: Request): String = buildString {
        append(booksProperties.api.url)
        append("?orderBy=newest&maxResults=10&key=${booksProperties.api.key}")
        genreToSubject(request.genre)?.let { append("&q=subject:$it") }
    }

    private fun genreToSubject(requestGenre: String): String? = booksProperties.genres[
        requestGenre.trim().lowercase().replace("\\s+".toRegex(), "-")
    ]

    data class Request(val genre: String = "")
}