package drobczyk.bartlomiej.springai.service.functions

import drobczyk.bartlomiej.springai.config.GoogleBooksProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Description
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class Functions {

    @Bean
    @Description("Fetch books by given genre")
    fun fetchBooks(googleBooksProperties: GoogleBooksProperties, restClient: RestClient): BooksService {
        return BooksService(googleBooksProperties, restClient)
    }
}