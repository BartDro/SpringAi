package drobczyk.bartlomiej.springai.engine

import org.springframework.web.multipart.MultipartFile

interface TranscriptService {
    fun transcribeAudio(file: MultipartFile): String
}