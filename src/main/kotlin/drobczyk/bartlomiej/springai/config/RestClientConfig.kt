package drobczyk.bartlomiej.springai.config

import org.springframework.boot.web.client.ClientHttpRequestFactories
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings
import org.springframework.boot.web.client.RestClientCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import java.time.Duration

@Configuration
class RestClientConfig {

    @Bean
    fun restClient(restClientCustomizer: RestClientCustomizer): RestClient =
        RestClient.builder()
            .apply { restClientCustomizer.customize(it) }
            .build()

    @Bean
    fun restClientCustomizer(): RestClientCustomizer {
        return RestClientCustomizer { restClientBuilder: RestClient.Builder ->
            restClientBuilder.requestFactory(
                ClientHttpRequestFactories.get(
                    ClientHttpRequestFactorySettings.DEFAULTS
                        .withConnectTimeout(Duration.ofSeconds(60))
                        .withReadTimeout(Duration.ofSeconds(60))
                )
            )
        }
    }
}