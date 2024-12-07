package drobczyk.bartlomiej.springai

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class SpringAiApplication

fun main(args: Array<String>) {
    runApplication<SpringAiApplication>(*args)
}
