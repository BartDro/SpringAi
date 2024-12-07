package drobczyk.bartlomiej.springai.service

import drobczyk.bartlomiej.springai.engine.ReasoningService
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.stereotype.Service

@Service
class OpenAiService(private val chatModel: ChatModel) : ReasoningService {

    override fun deriveResponse(prompt: String): String {
        val openAiPrompt = Prompt(
            prompt, OpenAiChatOptions.builder()
                .withFunction("fetchBooks")
                .build()
        )
        val response = chatModel.call(
            openAiPrompt
        )
        return response.result.output.content
    }
}