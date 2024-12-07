package drobczyk.bartlomiej.springai.engine

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AiService(
    private val transcriptService: TranscriptService,
    private val reasoningService: ReasoningService
) {
    fun executePromptFrom(audio: MultipartFile): String =
        transcriptService.transcribeAudio(audio).let { transcribedPrompt ->
            reasoningService.deriveResponse(transcribedPrompt)
        }
}