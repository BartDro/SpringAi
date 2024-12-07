package drobczyk.bartlomiej.springai.config

import com.assemblyai.api.AssemblyAI
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class AssemblyConfig {

    @Bean
    fun assemblyAi(assemblyProperties: AssemblyProperties): AssemblyAI {
        return AssemblyAI.builder().apiKey(assemblyProperties.key).build()
    }

    @Bean
    fun TranscriptOptionalParams(): TranscriptOptionalParams {
        return TranscriptOptionalParams.builder()
            .filterProfanity(true)
            .punctuate(true)
            .formatText(true)
            .disfluencies(true)
            .build()
    }
}

@Component
@ConfigurationProperties(prefix = "assembly-ai-api")
data class AssemblyProperties(var key: String = "")