package drobczyk.bartlomiej.springai.api

import drobczyk.bartlomiej.springai.engine.AiService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/ai-api/audio/prompt")
class AiApi(private val aiService: AiService) {

    @PostMapping
    fun execute(@RequestParam("audio") audio: MultipartFile): String {
        return aiService.executePromptFrom(audio)
    }
}