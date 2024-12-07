package drobczyk.bartlomiej.springai.service

import com.assemblyai.api.AssemblyAI
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams
import drobczyk.bartlomiej.springai.engine.TranscriptService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.util.*

@Service
class AssemblyService(
    private val assemblyAI: AssemblyAI,
    private val transcriptParams: TranscriptOptionalParams
) : TranscriptService {

    override fun transcribeAudio(file: MultipartFile): String =
        file.toAudio().let { recording ->
            assemblyAI.transcripts()
                .transcribe(recording, transcriptParams)
                .text.orElseThrow { Exception("Could not create transcript for ${file.name}") }
                .also { Files.deleteIfExists(recording.toPath()) }
        }

    private fun MultipartFile.toAudio(): File {
        return File.createTempFile("audio_${UUID.randomUUID()}", ".mp3").let { createdFile ->
            this.transferTo(createdFile)
            createdFile
        }
    }
}
