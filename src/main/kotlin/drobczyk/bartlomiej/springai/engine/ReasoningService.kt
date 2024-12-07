package drobczyk.bartlomiej.springai.engine

interface ReasoningService {
    fun deriveResponse(prompt: String): String
}